// Generated by com.stripe.generator.entity.SdkBuilder

package com.stripe.param.checkout;

import com.google.gson.annotations.SerializedName;
import com.stripe.net.ApiRequestParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;

@Getter
public class SessionCreateParams extends ApiRequestParams {
  /** The URL the customer will be directed to if they decide to go back to your website. */
  @SerializedName("cancel_url")
  String cancelUrl;

  /**
   * The reference to identify a payment made with Checkout. This reference will be echoed back in
   * Checkout webhooks.
   */
  @SerializedName("client_reference_id")
  String clientReferenceId;

  /**
   * The email address used to create the customer object. If you already know your customer's email
   * address, use this attribute to prefill it on Checkout.
   */
  @SerializedName("customer_email")
  String customerEmail;

  /** Specifies which fields in the response should be expanded. */
  @SerializedName("expand")
  List<String> expand;

  /** A list of items your customer is purchasing. */
  @SerializedName("line_items")
  List<LineItems> lineItems;

  /**
   * The IETF language tag of the locale Checkout is displayed in. If blank or `auto`, the browser's
   * locale is used. Supported values are `auto`, `da`, `de`, `en`, `es`, `fi`, `fr`, `it`, `ja`,
   * `nb`, `nl`, `pl`, `pt`, `sv`, or `zh`.
   */
  @SerializedName("locale")
  Locale locale;

  /** A subset of parameters to be passed to PaymentIntent creation. */
  @SerializedName("payment_intent_data")
  PaymentIntentData paymentIntentData;

  /** The list of payment method types (e.g. card) that this Checkout Session is allowed to use. */
  @SerializedName("payment_method_types")
  List<PaymentMethodTypes> paymentMethodTypes;

  /** A subset of parameters to be passed to subscription creation. */
  @SerializedName("subscription_data")
  SubscriptionData subscriptionData;

  /** The URL the customer will be directed to after a successful payment. */
  @SerializedName("success_url")
  String successUrl;

  private SessionCreateParams(
      String cancelUrl,
      String clientReferenceId,
      String customerEmail,
      List<String> expand,
      List<LineItems> lineItems,
      Locale locale,
      PaymentIntentData paymentIntentData,
      List<PaymentMethodTypes> paymentMethodTypes,
      SubscriptionData subscriptionData,
      String successUrl) {
    this.cancelUrl = cancelUrl;
    this.clientReferenceId = clientReferenceId;
    this.customerEmail = customerEmail;
    this.expand = expand;
    this.lineItems = lineItems;
    this.locale = locale;
    this.paymentIntentData = paymentIntentData;
    this.paymentMethodTypes = paymentMethodTypes;
    this.subscriptionData = subscriptionData;
    this.successUrl = successUrl;
  }

  public static Builder builder() {
    return new com.stripe.param.checkout.SessionCreateParams.Builder();
  }

  public static class Builder {
    private String cancelUrl;

    private String clientReferenceId;

    private String customerEmail;

    private List<String> expand;

    private List<LineItems> lineItems;

    private Locale locale;

    private PaymentIntentData paymentIntentData;

    private List<PaymentMethodTypes> paymentMethodTypes;

    private SubscriptionData subscriptionData;

    private String successUrl;

    /** Finalize and obtain parameter instance from this builder. */
    public SessionCreateParams build() {
      return new SessionCreateParams(
          this.cancelUrl,
          this.clientReferenceId,
          this.customerEmail,
          this.expand,
          this.lineItems,
          this.locale,
          this.paymentIntentData,
          this.paymentMethodTypes,
          this.subscriptionData,
          this.successUrl);
    }

    /**
     * Add an element to `expand` list. A list is initialized for the first call, and subsequent
     * calls adds additional elements to the original list. See {@link SessionCreateParams#expand}
     * for the field documentation.
     */
    public Builder addExpand(String element) {
      if (this.expand == null) {
        this.expand = new ArrayList<>();
      }
      this.expand.add(element);
      return this;
    }

    /**
     * Add an element to `lineItems` list. A list is initialized for the first call, and subsequent
     * calls adds additional elements to the original list. See {@link
     * SessionCreateParams#lineItems} for the field documentation.
     */
    public Builder addLineItems(LineItems element) {
      if (this.lineItems == null) {
        this.lineItems = new ArrayList<>();
      }
      this.lineItems.add(element);
      return this;
    }

    /**
     * Add an element to `paymentMethodTypes` list. A list is initialized for the first call, and
     * subsequent calls adds additional elements to the original list. See {@link
     * SessionCreateParams#paymentMethodTypes} for the field documentation.
     */
    public Builder addPaymentMethodTypes(PaymentMethodTypes element) {
      if (this.paymentMethodTypes == null) {
        this.paymentMethodTypes = new ArrayList<>();
      }
      this.paymentMethodTypes.add(element);
      return this;
    }

    /** The URL the customer will be directed to if they decide to go back to your website. */
    public Builder setCancelUrl(String cancelUrl) {
      this.cancelUrl = cancelUrl;
      return this;
    }

    /**
     * The reference to identify a payment made with Checkout. This reference will be echoed back in
     * Checkout webhooks.
     */
    public Builder setClientReferenceId(String clientReferenceId) {
      this.clientReferenceId = clientReferenceId;
      return this;
    }

    /**
     * The email address used to create the customer object. If you already know your customer's
     * email address, use this attribute to prefill it on Checkout.
     */
    public Builder setCustomerEmail(String customerEmail) {
      this.customerEmail = customerEmail;
      return this;
    }

    /**
     * The IETF language tag of the locale Checkout is displayed in. If blank or `auto`, the
     * browser's locale is used. Supported values are `auto`, `da`, `de`, `en`, `es`, `fi`, `fr`,
     * `it`, `ja`, `nb`, `nl`, `pl`, `pt`, `sv`, or `zh`.
     */
    public Builder setLocale(Locale locale) {
      this.locale = locale;
      return this;
    }

    /** A subset of parameters to be passed to PaymentIntent creation. */
    public Builder setPaymentIntentData(PaymentIntentData paymentIntentData) {
      this.paymentIntentData = paymentIntentData;
      return this;
    }

    /** A subset of parameters to be passed to subscription creation. */
    public Builder setSubscriptionData(SubscriptionData subscriptionData) {
      this.subscriptionData = subscriptionData;
      return this;
    }

    /** The URL the customer will be directed to after a successful payment. */
    public Builder setSuccessUrl(String successUrl) {
      this.successUrl = successUrl;
      return this;
    }
  }

  @Getter
  public static class LineItems {
    /** Amount intended to be collected by this Checkout Session. */
    @SerializedName("amount")
    Long amount;

    /**
     * Three-letter [ISO currency code](https://www.iso.org/iso-4217-currency-codes.html), in
     * lowercase. Must be a [supported currency](https://stripe.com/docs/currencies).
     */
    @SerializedName("currency")
    String currency;

    /** The description for the line item. */
    @SerializedName("description")
    String description;

    /** A list of images representing this line item. */
    @SerializedName("images")
    List<String> images;

    /** The name for the line item. */
    @SerializedName("name")
    String name;

    /** Quantity of the line item being purchased. */
    @SerializedName("quantity")
    Long quantity;

    private LineItems(
        Long amount,
        String currency,
        String description,
        List<String> images,
        String name,
        Long quantity) {
      this.amount = amount;
      this.currency = currency;
      this.description = description;
      this.images = images;
      this.name = name;
      this.quantity = quantity;
    }

    public static Builder builder() {
      return new com.stripe.param.checkout.SessionCreateParams.LineItems.Builder();
    }

    public static class Builder {
      private Long amount;

      private String currency;

      private String description;

      private List<String> images;

      private String name;

      private Long quantity;

      /** Finalize and obtain parameter instance from this builder. */
      public LineItems build() {
        return new LineItems(
            this.amount, this.currency, this.description, this.images, this.name, this.quantity);
      }

      /**
       * Add an element to `images` list. A list is initialized for the first call, and subsequent
       * calls adds additional elements to the original list. See {@link LineItems#images} for the
       * field documentation.
       */
      public Builder addImages(String element) {
        if (this.images == null) {
          this.images = new ArrayList<>();
        }
        this.images.add(element);
        return this;
      }

      /** Amount intended to be collected by this Checkout Session. */
      public Builder setAmount(Long amount) {
        this.amount = amount;
        return this;
      }

      /**
       * Three-letter [ISO currency code](https://www.iso.org/iso-4217-currency-codes.html), in
       * lowercase. Must be a [supported currency](https://stripe.com/docs/currencies).
       */
      public Builder setCurrency(String currency) {
        this.currency = currency;
        return this;
      }

      /** The description for the line item. */
      public Builder setDescription(String description) {
        this.description = description;
        return this;
      }

      /** The name for the line item. */
      public Builder setName(String name) {
        this.name = name;
        return this;
      }

      /** Quantity of the line item being purchased. */
      public Builder setQuantity(Long quantity) {
        this.quantity = quantity;
        return this;
      }
    }
  }

  @Getter
  public static class PaymentIntentData {
    /**
     * The amount of the application fee (if any) that will be applied to the payment and
     * transferred to the application owner's Stripe account. To use an application fee, the request
     * must be made on behalf of another account, using the `Stripe-Account` header or an OAuth key.
     * For more information, see the PaymentIntents [Connect usage
     * guide](/docs/payments/payment-intents/usage#connect).
     */
    @SerializedName("application_fee_amount")
    Long applicationFeeAmount;

    /** An arbitrary string attached to the object. Often useful for displaying to users. */
    @SerializedName("description")
    String description;

    /**
     * Set of key-value pairs that you can attach to an object. This can be useful for storing
     * additional information about the object in a structured format.
     */
    @SerializedName("metadata")
    Map<String, String> metadata;

    /**
     * The Stripe account ID for which these funds are intended. For details, see the PaymentIntents
     * [Connect usage guide](/docs/payments/payment-intents/usage#connect).
     */
    @SerializedName("on_behalf_of")
    String onBehalfOf;

    /** Email address that the receipt for the resulting payment will be sent to. */
    @SerializedName("receipt_email")
    String receiptEmail;

    /** Shipping information for this payment. */
    @SerializedName("shipping")
    Shipping shipping;

    /**
     * Extra information about the payment. This will appear on your customer's statement when this
     * payment succeeds in creating a charge.
     */
    @SerializedName("statement_descriptor")
    String statementDescriptor;

    /**
     * The parameters used to automatically create a Transfer when the payment succeeds. For more
     * information, see the PaymentIntents [Connect usage
     * guide](/docs/payments/payment-intents/usage#connect).
     */
    @SerializedName("transfer_data")
    TransferData transferData;

    private PaymentIntentData(
        Long applicationFeeAmount,
        String description,
        Map<String, String> metadata,
        String onBehalfOf,
        String receiptEmail,
        Shipping shipping,
        String statementDescriptor,
        TransferData transferData) {
      this.applicationFeeAmount = applicationFeeAmount;
      this.description = description;
      this.metadata = metadata;
      this.onBehalfOf = onBehalfOf;
      this.receiptEmail = receiptEmail;
      this.shipping = shipping;
      this.statementDescriptor = statementDescriptor;
      this.transferData = transferData;
    }

    public static Builder builder() {
      return new com.stripe.param.checkout.SessionCreateParams.PaymentIntentData.Builder();
    }

    public static class Builder {
      private Long applicationFeeAmount;

      private String description;

      private Map<String, String> metadata;

      private String onBehalfOf;

      private String receiptEmail;

      private Shipping shipping;

      private String statementDescriptor;

      private TransferData transferData;

      /** Finalize and obtain parameter instance from this builder. */
      public PaymentIntentData build() {
        return new PaymentIntentData(
            this.applicationFeeAmount,
            this.description,
            this.metadata,
            this.onBehalfOf,
            this.receiptEmail,
            this.shipping,
            this.statementDescriptor,
            this.transferData);
      }

      /**
       * Add a key/value pair to `metadata` map. A map is initialized for the first call, and
       * subsequent calls adds additional key/value pairs to the original map. See {@link
       * PaymentIntentData#metadata} for the field documentation.
       */
      public Builder putMetadata(String key, String value) {
        if (this.metadata == null) {
          this.metadata = new HashMap<>();
        }
        this.metadata.put(key, value);
        return this;
      }

      /**
       * The amount of the application fee (if any) that will be applied to the payment and
       * transferred to the application owner's Stripe account. To use an application fee, the
       * request must be made on behalf of another account, using the `Stripe-Account` header or an
       * OAuth key. For more information, see the PaymentIntents [Connect usage
       * guide](/docs/payments/payment-intents/usage#connect).
       */
      public Builder setApplicationFeeAmount(Long applicationFeeAmount) {
        this.applicationFeeAmount = applicationFeeAmount;
        return this;
      }

      /** An arbitrary string attached to the object. Often useful for displaying to users. */
      public Builder setDescription(String description) {
        this.description = description;
        return this;
      }

      /**
       * The Stripe account ID for which these funds are intended. For details, see the
       * PaymentIntents [Connect usage guide](/docs/payments/payment-intents/usage#connect).
       */
      public Builder setOnBehalfOf(String onBehalfOf) {
        this.onBehalfOf = onBehalfOf;
        return this;
      }

      /** Email address that the receipt for the resulting payment will be sent to. */
      public Builder setReceiptEmail(String receiptEmail) {
        this.receiptEmail = receiptEmail;
        return this;
      }

      /** Shipping information for this payment. */
      public Builder setShipping(Shipping shipping) {
        this.shipping = shipping;
        return this;
      }

      /**
       * Extra information about the payment. This will appear on your customer's statement when
       * this payment succeeds in creating a charge.
       */
      public Builder setStatementDescriptor(String statementDescriptor) {
        this.statementDescriptor = statementDescriptor;
        return this;
      }

      /**
       * The parameters used to automatically create a Transfer when the payment succeeds. For more
       * information, see the PaymentIntents [Connect usage
       * guide](/docs/payments/payment-intents/usage#connect).
       */
      public Builder setTransferData(TransferData transferData) {
        this.transferData = transferData;
        return this;
      }
    }

    @Getter
    public static class Shipping {
      /** Shipping address. */
      @SerializedName("address")
      Address address;

      /** The delivery service that shipped a physical product, such as Fedex, UPS, USPS, etc. */
      @SerializedName("carrier")
      String carrier;

      /** Recipient name. */
      @SerializedName("name")
      String name;

      /** Recipient phone (including extension). */
      @SerializedName("phone")
      String phone;

      /**
       * The tracking number for a physical product, obtained from the delivery service. If multiple
       * tracking numbers were generated for this purchase, please separate them with commas.
       */
      @SerializedName("tracking_number")
      String trackingNumber;

      private Shipping(
          Address address, String carrier, String name, String phone, String trackingNumber) {
        this.address = address;
        this.carrier = carrier;
        this.name = name;
        this.phone = phone;
        this.trackingNumber = trackingNumber;
      }

      public static Builder builder() {
        return new com.stripe.param.checkout.SessionCreateParams.PaymentIntentData.Shipping
            .Builder();
      }

      public static class Builder {
        private Address address;

        private String carrier;

        private String name;

        private String phone;

        private String trackingNumber;

        /** Finalize and obtain parameter instance from this builder. */
        public Shipping build() {
          return new Shipping(
              this.address, this.carrier, this.name, this.phone, this.trackingNumber);
        }

        /** Shipping address. */
        public Builder setAddress(Address address) {
          this.address = address;
          return this;
        }

        /** The delivery service that shipped a physical product, such as Fedex, UPS, USPS, etc. */
        public Builder setCarrier(String carrier) {
          this.carrier = carrier;
          return this;
        }

        /** Recipient name. */
        public Builder setName(String name) {
          this.name = name;
          return this;
        }

        /** Recipient phone (including extension). */
        public Builder setPhone(String phone) {
          this.phone = phone;
          return this;
        }

        /**
         * The tracking number for a physical product, obtained from the delivery service. If
         * multiple tracking numbers were generated for this purchase, please separate them with
         * commas.
         */
        public Builder setTrackingNumber(String trackingNumber) {
          this.trackingNumber = trackingNumber;
          return this;
        }
      }

      @Getter
      public static class Address {
        @SerializedName("city")
        String city;

        @SerializedName("country")
        String country;

        @SerializedName("line1")
        String line1;

        @SerializedName("line2")
        String line2;

        @SerializedName("postal_code")
        String postalCode;

        @SerializedName("state")
        String state;

        private Address(
            String city,
            String country,
            String line1,
            String line2,
            String postalCode,
            String state) {
          this.city = city;
          this.country = country;
          this.line1 = line1;
          this.line2 = line2;
          this.postalCode = postalCode;
          this.state = state;
        }

        public static Builder builder() {
          return new com.stripe.param.checkout.SessionCreateParams.PaymentIntentData.Shipping
              .Address.Builder();
        }

        public static class Builder {
          private String city;

          private String country;

          private String line1;

          private String line2;

          private String postalCode;

          private String state;

          /** Finalize and obtain parameter instance from this builder. */
          public Address build() {
            return new Address(
                this.city, this.country, this.line1, this.line2, this.postalCode, this.state);
          }

          public Builder setCity(String city) {
            this.city = city;
            return this;
          }

          public Builder setCountry(String country) {
            this.country = country;
            return this;
          }

          public Builder setLine1(String line1) {
            this.line1 = line1;
            return this;
          }

          public Builder setLine2(String line2) {
            this.line2 = line2;
            return this;
          }

          public Builder setPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
          }

          public Builder setState(String state) {
            this.state = state;
            return this;
          }
        }
      }
    }

    @Getter
    public static class TransferData {
      /**
       * If specified, successful charges will be attributed to the destination account for tax
       * reporting, and the funds from charges will be transferred to the destination account. The
       * ID of the resulting transfer will be returned on the successful charge's `transfer` field.
       */
      @SerializedName("destination")
      String destination;

      private TransferData(String destination) {
        this.destination = destination;
      }

      public static Builder builder() {
        return new com.stripe.param.checkout.SessionCreateParams.PaymentIntentData.TransferData
            .Builder();
      }

      public static class Builder {
        private String destination;

        /** Finalize and obtain parameter instance from this builder. */
        public TransferData build() {
          return new TransferData(this.destination);
        }

        /**
         * If specified, successful charges will be attributed to the destination account for tax
         * reporting, and the funds from charges will be transferred to the destination account. The
         * ID of the resulting transfer will be returned on the successful charge's `transfer`
         * field.
         */
        public Builder setDestination(String destination) {
          this.destination = destination;
          return this;
        }
      }
    }
  }

  @Getter
  public static class SubscriptionData {
    /** List of items, each with an attached plan. */
    @SerializedName("items")
    List<Items> items;

    /**
     * Set of key-value pairs that you can attach to an object. This can be useful for storing
     * additional information about the object in a structured format.
     */
    @SerializedName("metadata")
    Map<String, String> metadata;

    /**
     * Unix timestamp representing the end of the trial period the customer will get before being
     * charged for the first time. Has to be at least 48h in the future.
     */
    @SerializedName("trial_end")
    Long trialEnd;

    private SubscriptionData(List<Items> items, Map<String, String> metadata, Long trialEnd) {
      this.items = items;
      this.metadata = metadata;
      this.trialEnd = trialEnd;
    }

    public static Builder builder() {
      return new com.stripe.param.checkout.SessionCreateParams.SubscriptionData.Builder();
    }

    public static class Builder {
      private List<Items> items;

      private Map<String, String> metadata;

      private Long trialEnd;

      /** Finalize and obtain parameter instance from this builder. */
      public SubscriptionData build() {
        return new SubscriptionData(this.items, this.metadata, this.trialEnd);
      }

      /**
       * Add an element to `items` list. A list is initialized for the first call, and subsequent
       * calls adds additional elements to the original list. See {@link SubscriptionData#items} for
       * the field documentation.
       */
      public Builder addItems(Items element) {
        if (this.items == null) {
          this.items = new ArrayList<>();
        }
        this.items.add(element);
        return this;
      }

      /**
       * Add a key/value pair to `metadata` map. A map is initialized for the first call, and
       * subsequent calls adds additional key/value pairs to the original map. See {@link
       * SubscriptionData#metadata} for the field documentation.
       */
      public Builder putMetadata(String key, String value) {
        if (this.metadata == null) {
          this.metadata = new HashMap<>();
        }
        this.metadata.put(key, value);
        return this;
      }

      /**
       * Unix timestamp representing the end of the trial period the customer will get before being
       * charged for the first time. Has to be at least 48h in the future.
       */
      public Builder setTrialEnd(Long trialEnd) {
        this.trialEnd = trialEnd;
        return this;
      }
    }

    @Getter
    public static class Items {
      /** Plan ID for this item. */
      @SerializedName("plan")
      String plan;

      /** Quantity for this item. */
      @SerializedName("quantity")
      Long quantity;

      private Items(String plan, Long quantity) {
        this.plan = plan;
        this.quantity = quantity;
      }

      public static Builder builder() {
        return new com.stripe.param.checkout.SessionCreateParams.SubscriptionData.Items.Builder();
      }

      public static class Builder {
        private String plan;

        private Long quantity;

        /** Finalize and obtain parameter instance from this builder. */
        public Items build() {
          return new Items(this.plan, this.quantity);
        }

        /** Plan ID for this item. */
        public Builder setPlan(String plan) {
          this.plan = plan;
          return this;
        }

        /** Quantity for this item. */
        public Builder setQuantity(Long quantity) {
          this.quantity = quantity;
          return this;
        }
      }
    }
  }

  public enum Locale implements ApiRequestParams.Enum {
    @SerializedName("auto")
    AUTO("auto"),

    @SerializedName("da")
    DA("da"),

    @SerializedName("de")
    DE("de"),

    @SerializedName("en")
    EN("en"),

    @SerializedName("es")
    ES("es"),

    @SerializedName("fi")
    FI("fi"),

    @SerializedName("fr")
    FR("fr"),

    @SerializedName("it")
    IT("it"),

    @SerializedName("ja")
    JA("ja"),

    @SerializedName("nb")
    NB("nb"),

    @SerializedName("nl")
    NL("nl"),

    @SerializedName("pl")
    PL("pl"),

    @SerializedName("pt")
    PT("pt"),

    @SerializedName("sv")
    SV("sv"),

    @SerializedName("zh")
    ZH("zh");

    @Getter private final String value;

    Locale(String value) {
      this.value = value;
    }
  }

  public enum PaymentMethodTypes implements ApiRequestParams.Enum {
    @SerializedName("card")
    CARD("card");

    @Getter private final String value;

    PaymentMethodTypes(String value) {
      this.value = value;
    }
  }
}
