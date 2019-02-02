package com.stripe.functional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.stripe.BaseStripeTest;
import com.stripe.exception.EventDataObjectDeserializationException;
import com.stripe.model.Event;
import com.stripe.model.EventDataObjectDeserializer;
import com.stripe.model.Invoice;
import com.stripe.model.StripeObject;
import com.stripe.net.ApiResource;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import org.junit.Test;

public class EventDataObjectDeserializerTest extends BaseStripeTest {

  @Test
  public void testInvoiceEventBestAttemptGetter() throws IOException {
    final String invoiceEvent = getResourceAsString("/api_fixtures/invoice_event.json");
    Event event = ApiResource.GSON.fromJson(invoiceEvent, Event.class);

    // In practice, you may only rely on a few fields from the event, and those fields are
    // fully compatible with the current schema. You should be able to access those fields, not
    // because of a few legacy fields are failing the entire event deserialization.

    // This is a deprecated approach, and not recommended because you will
    // get JSON parse exception upon schema incompatibility
    try {
      event.getData().getObject();
      fail("Getting old events through deprecated method should fail");
    } catch (JsonParseException e) {
      // verified that deprecated get object fails
    }

    // Here's an example of a best-attempt approach to get access to the information you
    // need from the object
    EventDataObjectDeserializer dataObjectDeserializer = event.getDataObjectDeserializer();
    String invoiceId = null;
    if (dataObjectDeserializer.deserialize()) {
      Invoice invoice = (Invoice) dataObjectDeserializer.getObject();
      invoice.getId();
      fail("should gets false in trying to deserialize");
    } else {
      try {
        Invoice invoice = (Invoice) dataObjectDeserializer.deserializeUnsafe();
        invoiceId = invoice.getId();
        fail("should fail in unsafe deserialization");
      } catch (EventDataObjectDeserializationException e) {
        JsonElement parsed = new JsonParser().parse(e.getRawJson());
        invoiceId = parsed.getAsJsonObject().get("id").getAsString();
      }
    }
    assertNotNull(invoiceId);
  }

  @Test
  public void testInvoiceEventBestAttemptFullModel() throws IOException {
    final String invoiceEvent = getResourceAsString("/api_fixtures/invoice_event.json");
    Event event = ApiResource.GSON.fromJson(invoiceEvent, Event.class);

    EventDataObjectDeserializer dataObjectDeserializer = event.getDataObjectDeserializer();
    EventDataObjectDeserializer.CompatibilityTransformer invoiceTransformer =
        new com.stripe.model.EventDataObjectDeserializer.CompatibilityTransformer() {
          @Override
          public JsonObject transform(JsonObject rawJsonObject, String apiVersion,
                                      String eventType) {
            // Attempt to be forward compatible only for invoice events
            if (!eventType.startsWith("invoice.")) {
              return rawJsonObject;
            }

            // update guide on Invoice: https://stripe.com/docs/upgrades#2012-10-26
            // `lines` for line items are of `InvoiceLineItemCollection` and not
            // List<LineItem>, we we convert simple JSON array to an expected JSON format
            if (versionToDate(apiVersion).before(versionToDate("2012-10-26"))) {
              JsonArray lines = rawJsonObject.get("lines").getAsJsonArray();
              JsonObject paginatedLines = new JsonObject();
              paginatedLines.add("data", lines);
              paginatedLines.add("has_more", new JsonPrimitive(false));
              paginatedLines.add("total_count", new JsonPrimitive(lines.size()));
              rawJsonObject.add("lines", paginatedLines);
            }

            // other version updates
            // ...

            // update guide on Invoice: https://stripe.com/docs/upgrades#2017-12-14
            // invoice item description is always set, if you downstream application
            // code expects non-null description, consider adding default values
            if (versionToDate(apiVersion).before(versionToDate("2017-12-14"))) {
              JsonArray lineItems =
                  rawJsonObject.get("lines").getAsJsonObject().get("data").getAsJsonArray();
              Iterator<JsonElement> iterator = lineItems.iterator();
              while (iterator.hasNext()) {
                JsonObject item = iterator.next().getAsJsonObject();
                if (!item.has("description")) {
                  item.add("description", new JsonPrimitive("DEFAULT DESCRIPTION"));
                }
              }
            }

            // update guide on Invoice: https://stripe.com/docs/upgrades#2018-05-21
            // change in semantics of `id` for invoice line items, but schema remains the same

            // update guide on Invoice: https://stripe.com/docs/upgrades#2018-10-31
            // billing_reason taking a new enum, but the old enum is still valid, so no change.

            // following update guide on Invoice: https://stripe.com/docs/upgrades#2012-10-26
            if (versionToDate(apiVersion).before(versionToDate("2018-11-08"))) {
              // From change log, `closed` is deprecated in favor of `auto_advance`
              // when `closed` is true, `auto_advance` is false.
              boolean closedValue = rawJsonObject.get("closed").getAsBoolean();
              rawJsonObject.add("auto_advance", new JsonPrimitive(!closedValue));

              // From change log, `forgiven` is deprecated in favor of `uncollectible` status.
              if (rawJsonObject.get("forgiven").getAsBoolean()) {
                rawJsonObject.add("status", new JsonPrimitive("uncollectible"));
              }
            }
            return rawJsonObject;
          }
        };

    StripeObject deserialized = dataObjectDeserializer.deserializeUnsafeWith(invoiceTransformer);
    Invoice invoice = (Invoice) deserialized;

    JsonObject rawEventDataObject =
        new JsonParser().parse(dataObjectDeserializer.getRawJson()).getAsJsonObject();

    // 2012-10-26 update
    // used to be array in raw JSON
    assertTrue(rawEventDataObject.get("lines").isJsonArray());
    // now a stripe collection
    assertTrue(invoice.getLines().getData().size() > 0);

    // 2017-12-14 update
    // used to have no description
    assertNull(rawEventDataObject.get("lines").getAsJsonArray()
        .get(0).getAsJsonObject().get("description"));
    // now contains specified default
    assertEquals("DEFAULT DESCRIPTION", invoice.getLines().getData().get(0)
        .getDescription());

    // 2018-11-08 update
    // used to have no concept of auto-advance
    assertNull(rawEventDataObject.get("auto_advance"));
    assertEquals(false, rawEventDataObject.get("closed").getAsBoolean());
    // now has value depending on "closed"
    assertTrue(invoice.getAutoAdvance());
  }

  private Date versionToDate(String version) {
    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    try {
      return formatter.parse(version);
    } catch (ParseException e) {
      throw new IllegalStateException("Failing to parse version date to date", e);
    }
  }
}
