package com.stripe.param;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNull;

import com.google.common.collect.ImmutableMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class PaymentIntentCreateParamsTest {

  @Test
  public void testAddElement() {
    final PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
        .addPaymentMethodType("card")
        .addPaymentMethodType("card_present")
        .addExpand("application")
        .addExpand("customer")
        .addExpand("on_behalf")
        .build();

    assertEquals(
        Arrays.asList("card", "card_present"),
        params.getPaymentMethodTypes());
    assertEquals(Arrays.asList("application", "customer", "on_behalf"),
        params.getExpand());
  }

  @Test
  public void testAddAllElement() {
    final PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
        .addAllExpand(Arrays.asList("application", "customer"))
        .addAllExpand(Arrays.asList("on_behalf"))
        .build();

    assertEquals(Arrays.asList("application", "customer", "on_behalf"), params.getExpand());
  }

  @Test
  public void testAddNoElementGetNullList() {
    final PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
        .build();

    assertNull(params.getExpand());
    assertNull(params.getPaymentMethodTypes());
  }

  @Test
  public void testPutKeyValue() {
    final PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
        .putMetadata("key1", "val1")
        .putMetadata("key2", "val2")
        .build();

    Map<String, String> metadata = new HashMap<>();
    metadata.put("key1", "val1");
    metadata.put("key2", "val2");
    assertEquals(metadata, params.getMetadata());
  }

  @Test
  public void testPutAllKeyValue() {
    final PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
        .putAllMetadata(ImmutableMap.of("key1", "val1", "key2", "val2"))
        .putAllMetadata(ImmutableMap.of("key3", "val3", "key4", "val4"))
        .build();

    Map<String, String> metadata = new HashMap<>();
    metadata.put("key1", "val1");
    metadata.put("key2", "val2");
    metadata.put("key3", "val3");
    metadata.put("key4", "val4");
    assertEquals(metadata, params.getMetadata());
  }

  @Test
  public void testPutNoKeyValueGetNullMap() {
    final PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
        .build();

    assertNull(params.getMetadata());
  }
}