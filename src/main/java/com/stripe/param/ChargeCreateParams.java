// Generated by com.stripe.generator.entity.SdkBuilder

package com.stripe.param;

import com.google.gson.annotations.SerializedName;
import com.stripe.net.ApiRequestParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;

@Getter
public class ChargeCreateParams extends ApiRequestParams {
  /**
   * A positive integer representing how much to charge, in the [smallest currency
   * unit](https://stripe.com/docs/currencies#zero-decimal) (e.g., `100` cents to charge $1.00, or
   * `100` to charge ¥100, a zero-decimal currency). The minimum amount is $0.50 USD or [equivalent
   * in charge currency](https://stripe.com/docs/currencies#minimum-and-maximum-charge-amounts).
   */
  @SerializedName("amount")
  Long amount;

  @SerializedName("application_fee")
  Long applicationFee;

  /**
   * A fee in %s that will be applied to the charge and transferred to the application owner's
   * Stripe account. The request must be made with an OAuth key or the `Stripe-Account` header in
   * order to take an application fee. For more information, see the application fees
   * [documentation](https://stripe.com/docs/connect/direct-charges#collecting-fees).
   */
  @SerializedName("application_fee_amount")
  Long applicationFeeAmount;

  /**
   * Whether to immediately capture the charge. Defaults to `true`. When `false`, the charge issues
   * an authorization (or pre-authorization), and will need to be [captured](#capture_charge) later.
   * Uncaptured charges expire in _seven days_. For more information, see the [authorizing charges
   * and settling later](https://stripe.com/docs/charges#auth-and-capture) documentation.
   */
  @SerializedName("capture")
  Boolean capture;

  /** A token, like the ones returned by [Stripe.js](https://stripe.com/docs/stripe.js). */
  @SerializedName("card")
  Object card;

  /**
   * Three-letter [ISO currency code](https://www.iso.org/iso-4217-currency-codes.html), in
   * lowercase. Must be a [supported currency](https://stripe.com/docs/currencies).
   */
  @SerializedName("currency")
  String currency;

  /** The ID of an existing customer that will be charged in this request. */
  @SerializedName("customer")
  String customer;

  /**
   * An arbitrary string which you can attach to a `Charge` object. It is displayed when in the web
   * interface alongside the charge. Note that if you use Stripe to send automatic email receipts to
   * your customers, your receipt emails will include the `description` of the charge(s) that they
   * are describing.
   */
  @SerializedName("description")
  String description;

  @SerializedName("destination")
  Destination destination;

  /** Specifies which fields in the response should be expanded. */
  @SerializedName("expand")
  List<String> expand;

  /**
   * Set of key-value pairs that you can attach to an object. This can be useful for storing
   * additional information about the object in a structured format.
   */
  @SerializedName("metadata")
  Map<String, String> metadata;

  /**
   * The Stripe account ID for which these funds are intended. Automatically set if you use the
   * `destination` parameter. For details, see [Creating Separate Charges and
   * Transfers](https://stripe.com/docs/connect/charges-transfers#on-behalf-of).
   */
  @SerializedName("on_behalf_of")
  String onBehalfOf;

  /**
   * The email address to which this charge's [receipt](https://stripe.com/docs/dashboard/receipts)
   * will be sent. The receipt will not be sent until the charge is paid, and no receipts will be
   * sent for test mode charges. If this charge is for a
   * [Customer](https://stripe.com/docs/api/customers/object), the email address specified here will
   * override the customer's email address. If `receipt_email` is specified for a charge in live
   * mode, a receipt will be sent regardless of your [email
   * settings](https://dashboard.stripe.com/account/emails).
   */
  @SerializedName("receipt_email")
  String receiptEmail;

  /** Shipping information for the charge. Helps prevent fraud on charges for physical goods. */
  @SerializedName("shipping")
  Shipping shipping;

  /**
   * A payment source to be charged. This can be the ID of a
   * [card](https://stripe.com/docs/api#cards) (i.e., credit or debit card), a [bank
   * account](https://stripe.com/docs/api#bank_accounts), a
   * [source](https://stripe.com/docs/api#sources), a [token](https://stripe.com/docs/api#tokens),
   * or a [connected
   * account](https://stripe.com/docs/connect/account-debits#charging-a-connected-account). For
   * certain sources---namely, [cards](https://stripe.com/docs/api#cards), [bank
   * accounts](https://stripe.com/docs/api#bank_accounts), and attached
   * [sources](https://stripe.com/docs/api#sources)---you must also pass the ID of the associated
   * customer.
   */
  @SerializedName("source")
  Object source;

  /**
   * An arbitrary string to be displayed on your customer's credit card statement. This can be up to
   * _22 characters_. As an example, if your website is `RunClub` and the item you're charging for
   * is a race ticket, you might want to specify a `statement_descriptor` of `RunClub 5K race
   * ticket`. The statement description must contain at least one letter, must not contain `"'`
   * characters, and will appear on your customer's statement in capital letters. Non-ASCII
   * characters are automatically stripped. While most banks and card issuers display this
   * information consistently, some might display it incorrectly or not at all.
   */
  @SerializedName("statement_descriptor")
  String statementDescriptor;

  /**
   * An optional dictionary including the account to automatically transfer to as part of a
   * destination charge. [See the Connect
   * documentation](https://stripe.com/docs/connect/destination-charges) for details.
   */
  @SerializedName("transfer_data")
  TransferData transferData;

  /**
   * A string that identifies this transaction as part of a group. For details, see [Grouping
   * transactions](https://stripe.com/docs/connect/charges-transfers#grouping-transactions).
   */
  @SerializedName("transfer_group")
  String transferGroup;

  private ChargeCreateParams(
      Long amount,
      Long applicationFee,
      Long applicationFeeAmount,
      Boolean capture,
      Object card,
      String currency,
      String customer,
      String description,
      Destination destination,
      List<String> expand,
      Map<String, String> metadata,
      String onBehalfOf,
      String receiptEmail,
      Shipping shipping,
      Object source,
      String statementDescriptor,
      TransferData transferData,
      String transferGroup) {
    this.amount = amount;
    this.applicationFee = applicationFee;
    this.applicationFeeAmount = applicationFeeAmount;
    this.capture = capture;
    this.card = card;
    this.currency = currency;
    this.customer = customer;
    this.description = description;
    this.destination = destination;
    this.expand = expand;
    this.metadata = metadata;
    this.onBehalfOf = onBehalfOf;
    this.receiptEmail = receiptEmail;
    this.shipping = shipping;
    this.source = source;
    this.statementDescriptor = statementDescriptor;
    this.transferData = transferData;
    this.transferGroup = transferGroup;
  }

  public static Builder builder() {
    return new com.stripe.param.ChargeCreateParams.Builder();
  }

  public static class Builder {
    private Long amount;

    private Long applicationFee;

    private Long applicationFeeAmount;

    private Boolean capture;

    private Object card;

    private String currency;

    private String customer;

    private String description;

    private Destination destination;

    private List<String> expand;

    private Map<String, String> metadata;

    private String onBehalfOf;

    private String receiptEmail;

    private Shipping shipping;

    private Object source;

    private String statementDescriptor;

    private TransferData transferData;

    private String transferGroup;

    /** Finalize and obtain parameter instance from this builder. */
    public ChargeCreateParams build() {
      return new ChargeCreateParams(
          this.amount,
          this.applicationFee,
          this.applicationFeeAmount,
          this.capture,
          this.card,
          this.currency,
          this.customer,
          this.description,
          this.destination,
          this.expand,
          this.metadata,
          this.onBehalfOf,
          this.receiptEmail,
          this.shipping,
          this.source,
          this.statementDescriptor,
          this.transferData,
          this.transferGroup);
    }

    /**
     * Add an element to `expand` list. A list is initialized for the first call, and subsequent
     * calls adds additional elements to the original list. See {@link ChargeCreateParams#expand}
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
     * Add a key/value pair to `metadata` map. A map is initialized for the first call, and
     * subsequent calls adds additional key/value pairs to the original map. See {@link
     * ChargeCreateParams#metadata} for the field documentation.
     */
    public Builder putMetadata(String key, String value) {
      if (this.metadata == null) {
        this.metadata = new HashMap<>();
      }
      this.metadata.put(key, value);
      return this;
    }

    /**
     * A positive integer representing how much to charge, in the [smallest currency
     * unit](https://stripe.com/docs/currencies#zero-decimal) (e.g., `100` cents to charge $1.00, or
     * `100` to charge ¥100, a zero-decimal currency). The minimum amount is $0.50 USD or
     * [equivalent in charge
     * currency](https://stripe.com/docs/currencies#minimum-and-maximum-charge-amounts).
     */
    public Builder setAmount(Long amount) {
      this.amount = amount;
      return this;
    }

    /**
     * A fee in %s that will be applied to the charge and transferred to the application owner's
     * Stripe account. The request must be made with an OAuth key or the `Stripe-Account` header in
     * order to take an application fee. For more information, see the application fees
     * [documentation](https://stripe.com/docs/connect/direct-charges#collecting-fees).
     */
    public Builder setApplicationFeeAmount(Long applicationFeeAmount) {
      this.applicationFeeAmount = applicationFeeAmount;
      return this;
    }

    public Builder setApplicationFee(Long applicationFee) {
      this.applicationFee = applicationFee;
      return this;
    }

    /**
     * Whether to immediately capture the charge. Defaults to `true`. When `false`, the charge
     * issues an authorization (or pre-authorization), and will need to be
     * [captured](#capture_charge) later. Uncaptured charges expire in _seven days_. For more
     * information, see the [authorizing charges and settling
     * later](https://stripe.com/docs/charges#auth-and-capture) documentation.
     */
    public Builder setCapture(Boolean capture) {
      this.capture = capture;
      return this;
    }

    /** A token, like the ones returned by [Stripe.js](https://stripe.com/docs/stripe.js). */
    public Builder setCard(Card card) {
      this.card = card;
      return this;
    }

    /** A token, like the ones returned by [Stripe.js](https://stripe.com/docs/stripe.js). */
    public Builder setCard(String card) {
      this.card = card;
      return this;
    }

    /** A token, like the ones returned by [Stripe.js](https://stripe.com/docs/stripe.js). */
    public Builder setCard(Map<String, Object> card) {
      this.card = card;
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

    /** The ID of an existing customer that will be charged in this request. */
    public Builder setCustomer(String customer) {
      this.customer = customer;
      return this;
    }

    /**
     * An arbitrary string which you can attach to a `Charge` object. It is displayed when in the
     * web interface alongside the charge. Note that if you use Stripe to send automatic email
     * receipts to your customers, your receipt emails will include the `description` of the
     * charge(s) that they are describing.
     */
    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    public Builder setDestination(Destination destination) {
      this.destination = destination;
      return this;
    }

    /**
     * The Stripe account ID for which these funds are intended. Automatically set if you use the
     * `destination` parameter. For details, see [Creating Separate Charges and
     * Transfers](https://stripe.com/docs/connect/charges-transfers#on-behalf-of).
     */
    public Builder setOnBehalfOf(String onBehalfOf) {
      this.onBehalfOf = onBehalfOf;
      return this;
    }

    /**
     * The email address to which this charge's
     * [receipt](https://stripe.com/docs/dashboard/receipts) will be sent. The receipt will not be
     * sent until the charge is paid, and no receipts will be sent for test mode charges. If this
     * charge is for a [Customer](https://stripe.com/docs/api/customers/object), the email address
     * specified here will override the customer's email address. If `receipt_email` is specified
     * for a charge in live mode, a receipt will be sent regardless of your [email
     * settings](https://dashboard.stripe.com/account/emails).
     */
    public Builder setReceiptEmail(String receiptEmail) {
      this.receiptEmail = receiptEmail;
      return this;
    }

    /** Shipping information for the charge. Helps prevent fraud on charges for physical goods. */
    public Builder setShipping(Shipping shipping) {
      this.shipping = shipping;
      return this;
    }

    /**
     * A payment source to be charged. This can be the ID of a
     * [card](https://stripe.com/docs/api#cards) (i.e., credit or debit card), a [bank
     * account](https://stripe.com/docs/api#bank_accounts), a
     * [source](https://stripe.com/docs/api#sources), a [token](https://stripe.com/docs/api#tokens),
     * or a [connected
     * account](https://stripe.com/docs/connect/account-debits#charging-a-connected-account). For
     * certain sources---namely, [cards](https://stripe.com/docs/api#cards), [bank
     * accounts](https://stripe.com/docs/api#bank_accounts), and attached
     * [sources](https://stripe.com/docs/api#sources)---you must also pass the ID of the associated
     * customer.
     */
    public Builder setSource(Source source) {
      this.source = source;
      return this;
    }

    /**
     * A payment source to be charged. This can be the ID of a
     * [card](https://stripe.com/docs/api#cards) (i.e., credit or debit card), a [bank
     * account](https://stripe.com/docs/api#bank_accounts), a
     * [source](https://stripe.com/docs/api#sources), a [token](https://stripe.com/docs/api#tokens),
     * or a [connected
     * account](https://stripe.com/docs/connect/account-debits#charging-a-connected-account). For
     * certain sources---namely, [cards](https://stripe.com/docs/api#cards), [bank
     * accounts](https://stripe.com/docs/api#bank_accounts), and attached
     * [sources](https://stripe.com/docs/api#sources)---you must also pass the ID of the associated
     * customer.
     */
    public Builder setSource(String source) {
      this.source = source;
      return this;
    }

    /**
     * A payment source to be charged. This can be the ID of a
     * [card](https://stripe.com/docs/api#cards) (i.e., credit or debit card), a [bank
     * account](https://stripe.com/docs/api#bank_accounts), a
     * [source](https://stripe.com/docs/api#sources), a [token](https://stripe.com/docs/api#tokens),
     * or a [connected
     * account](https://stripe.com/docs/connect/account-debits#charging-a-connected-account). For
     * certain sources---namely, [cards](https://stripe.com/docs/api#cards), [bank
     * accounts](https://stripe.com/docs/api#bank_accounts), and attached
     * [sources](https://stripe.com/docs/api#sources)---you must also pass the ID of the associated
     * customer.
     */
    public Builder setSource(Map<String, Object> source) {
      this.source = source;
      return this;
    }

    /**
     * An arbitrary string to be displayed on your customer's credit card statement. This can be up
     * to _22 characters_. As an example, if your website is `RunClub` and the item you're charging
     * for is a race ticket, you might want to specify a `statement_descriptor` of `RunClub 5K race
     * ticket`. The statement description must contain at least one letter, must not contain `"'`
     * characters, and will appear on your customer's statement in capital letters. Non-ASCII
     * characters are automatically stripped. While most banks and card issuers display this
     * information consistently, some might display it incorrectly or not at all.
     */
    public Builder setStatementDescriptor(String statementDescriptor) {
      this.statementDescriptor = statementDescriptor;
      return this;
    }

    /**
     * An optional dictionary including the account to automatically transfer to as part of a
     * destination charge. [See the Connect
     * documentation](https://stripe.com/docs/connect/destination-charges) for details.
     */
    public Builder setTransferData(TransferData transferData) {
      this.transferData = transferData;
      return this;
    }

    /**
     * A string that identifies this transaction as part of a group. For details, see [Grouping
     * transactions](https://stripe.com/docs/connect/charges-transfers#grouping-transactions).
     */
    public Builder setTransferGroup(String transferGroup) {
      this.transferGroup = transferGroup;
      return this;
    }
  }

  @Getter
  public static class Card {
    @SerializedName("emv_auth_data")
    String emvAuthData;

    @SerializedName("encrypted_pin")
    String encryptedPin;

    @SerializedName("encrypted_pin_key_id")
    String encryptedPinKeyId;

    @SerializedName("object")
    String object;

    @SerializedName("processing_method")
    ProcessingMethod processingMethod;

    @SerializedName("read_method")
    ReadMethod readMethod;

    private Card(
        String emvAuthData,
        String encryptedPin,
        String encryptedPinKeyId,
        String object,
        ProcessingMethod processingMethod,
        ReadMethod readMethod) {
      this.emvAuthData = emvAuthData;
      this.encryptedPin = encryptedPin;
      this.encryptedPinKeyId = encryptedPinKeyId;
      this.object = object;
      this.processingMethod = processingMethod;
      this.readMethod = readMethod;
    }

    public static Builder builder() {
      return new com.stripe.param.ChargeCreateParams.Card.Builder();
    }

    public static class Builder {
      private String emvAuthData;

      private String encryptedPin;

      private String encryptedPinKeyId;

      private String object;

      private ProcessingMethod processingMethod;

      private ReadMethod readMethod;

      /** Finalize and obtain parameter instance from this builder. */
      public Card build() {
        return new Card(
            this.emvAuthData,
            this.encryptedPin,
            this.encryptedPinKeyId,
            this.object,
            this.processingMethod,
            this.readMethod);
      }

      public Builder setEmvAuthData(String emvAuthData) {
        this.emvAuthData = emvAuthData;
        return this;
      }

      public Builder setEncryptedPinKeyId(String encryptedPinKeyId) {
        this.encryptedPinKeyId = encryptedPinKeyId;
        return this;
      }

      public Builder setEncryptedPin(String encryptedPin) {
        this.encryptedPin = encryptedPin;
        return this;
      }

      public Builder setObject(String object) {
        this.object = object;
        return this;
      }

      public Builder setProcessingMethod(ProcessingMethod processingMethod) {
        this.processingMethod = processingMethod;
        return this;
      }

      public Builder setReadMethod(ReadMethod readMethod) {
        this.readMethod = readMethod;
        return this;
      }
    }

    public enum ProcessingMethod implements ApiRequestParams.Enum {
      @SerializedName("quick_chip")
      QUICK_CHIP("quick_chip"),

      @SerializedName("traditional")
      TRADITIONAL("traditional");

      @Getter private final String value;

      ProcessingMethod(String value) {
        this.value = value;
      }
    }

    public enum ReadMethod implements ApiRequestParams.Enum {
      @SerializedName("contact")
      CONTACT("contact"),

      @SerializedName("contact_emv")
      CONTACT_EMV("contact_emv"),

      @SerializedName("contactless")
      CONTACTLESS("contactless"),

      @SerializedName("contactless_emv")
      CONTACTLESS_EMV("contactless_emv"),

      @SerializedName("contactless_magstripe_mode")
      CONTACTLESS_MAGSTRIPE_MODE("contactless_magstripe_mode"),

      @SerializedName("insert")
      INSERT("insert"),

      @SerializedName("keyed")
      KEYED("keyed"),

      @SerializedName("magnetic_stripe_fallback")
      MAGNETIC_STRIPE_FALLBACK("magnetic_stripe_fallback"),

      @SerializedName("magnetic_stripe_track2")
      MAGNETIC_STRIPE_TRACK2("magnetic_stripe_track2"),

      @SerializedName("swipe")
      SWIPE("swipe");

      @Getter private final String value;

      ReadMethod(String value) {
        this.value = value;
      }
    }
  }

  @Getter
  public static class Destination {
    /** ID of an existing, connected Stripe account. */
    @SerializedName("account")
    String account;

    /**
     * The amount to transfer to the destination account without creating an `Application Fee`
     * object. Cannot be combined with the `application_fee` parameter. Must be less than or equal
     * to the charge amount.
     */
    @SerializedName("amount")
    Long amount;

    private Destination(String account, Long amount) {
      this.account = account;
      this.amount = amount;
    }

    public static Builder builder() {
      return new com.stripe.param.ChargeCreateParams.Destination.Builder();
    }

    public static class Builder {
      private String account;

      private Long amount;

      /** Finalize and obtain parameter instance from this builder. */
      public Destination build() {
        return new Destination(this.account, this.amount);
      }

      /** ID of an existing, connected Stripe account. */
      public Builder setAccount(String account) {
        this.account = account;
        return this;
      }

      /**
       * The amount to transfer to the destination account without creating an `Application Fee`
       * object. Cannot be combined with the `application_fee` parameter. Must be less than or equal
       * to the charge amount.
       */
      public Builder setAmount(Long amount) {
        this.amount = amount;
        return this;
      }
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
      return new com.stripe.param.ChargeCreateParams.Shipping.Builder();
    }

    public static class Builder {
      private Address address;

      private String carrier;

      private String name;

      private String phone;

      private String trackingNumber;

      /** Finalize and obtain parameter instance from this builder. */
      public Shipping build() {
        return new Shipping(this.address, this.carrier, this.name, this.phone, this.trackingNumber);
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
       * The tracking number for a physical product, obtained from the delivery service. If multiple
       * tracking numbers were generated for this purchase, please separate them with commas.
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
        return new com.stripe.param.ChargeCreateParams.Shipping.Address.Builder();
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
  public static class Source {
    @SerializedName("emv_auth_data")
    String emvAuthData;

    @SerializedName("encrypted_pin")
    String encryptedPin;

    @SerializedName("encrypted_pin_key_id")
    String encryptedPinKeyId;

    @SerializedName("object")
    String object;

    @SerializedName("processing_method")
    ProcessingMethod processingMethod;

    @SerializedName("read_method")
    ReadMethod readMethod;

    private Source(
        String emvAuthData,
        String encryptedPin,
        String encryptedPinKeyId,
        String object,
        ProcessingMethod processingMethod,
        ReadMethod readMethod) {
      this.emvAuthData = emvAuthData;
      this.encryptedPin = encryptedPin;
      this.encryptedPinKeyId = encryptedPinKeyId;
      this.object = object;
      this.processingMethod = processingMethod;
      this.readMethod = readMethod;
    }

    public static Builder builder() {
      return new com.stripe.param.ChargeCreateParams.Source.Builder();
    }

    public static class Builder {
      private String emvAuthData;

      private String encryptedPin;

      private String encryptedPinKeyId;

      private String object;

      private ProcessingMethod processingMethod;

      private ReadMethod readMethod;

      /** Finalize and obtain parameter instance from this builder. */
      public Source build() {
        return new Source(
            this.emvAuthData,
            this.encryptedPin,
            this.encryptedPinKeyId,
            this.object,
            this.processingMethod,
            this.readMethod);
      }

      public Builder setEmvAuthData(String emvAuthData) {
        this.emvAuthData = emvAuthData;
        return this;
      }

      public Builder setEncryptedPinKeyId(String encryptedPinKeyId) {
        this.encryptedPinKeyId = encryptedPinKeyId;
        return this;
      }

      public Builder setEncryptedPin(String encryptedPin) {
        this.encryptedPin = encryptedPin;
        return this;
      }

      public Builder setObject(String object) {
        this.object = object;
        return this;
      }

      public Builder setProcessingMethod(ProcessingMethod processingMethod) {
        this.processingMethod = processingMethod;
        return this;
      }

      public Builder setReadMethod(ReadMethod readMethod) {
        this.readMethod = readMethod;
        return this;
      }
    }

    public enum ProcessingMethod implements ApiRequestParams.Enum {
      @SerializedName("quick_chip")
      QUICK_CHIP("quick_chip"),

      @SerializedName("traditional")
      TRADITIONAL("traditional");

      @Getter private final String value;

      ProcessingMethod(String value) {
        this.value = value;
      }
    }

    public enum ReadMethod implements ApiRequestParams.Enum {
      @SerializedName("contact")
      CONTACT("contact"),

      @SerializedName("contact_emv")
      CONTACT_EMV("contact_emv"),

      @SerializedName("contactless")
      CONTACTLESS("contactless"),

      @SerializedName("contactless_emv")
      CONTACTLESS_EMV("contactless_emv"),

      @SerializedName("contactless_magstripe_mode")
      CONTACTLESS_MAGSTRIPE_MODE("contactless_magstripe_mode"),

      @SerializedName("insert")
      INSERT("insert"),

      @SerializedName("keyed")
      KEYED("keyed"),

      @SerializedName("magnetic_stripe_fallback")
      MAGNETIC_STRIPE_FALLBACK("magnetic_stripe_fallback"),

      @SerializedName("magnetic_stripe_track2")
      MAGNETIC_STRIPE_TRACK2("magnetic_stripe_track2"),

      @SerializedName("swipe")
      SWIPE("swipe");

      @Getter private final String value;

      ReadMethod(String value) {
        this.value = value;
      }
    }
  }

  @Getter
  public static class TransferData {
    /**
     * The amount transferred to the destination account, if specified. By default, the entire
     * charge amount is transferred to the destination account.
     */
    @SerializedName("amount")
    Long amount;

    /** ID of an existing, connected Stripe account. */
    @SerializedName("destination")
    String destination;

    private TransferData(Long amount, String destination) {
      this.amount = amount;
      this.destination = destination;
    }

    public static Builder builder() {
      return new com.stripe.param.ChargeCreateParams.TransferData.Builder();
    }

    public static class Builder {
      private Long amount;

      private String destination;

      /** Finalize and obtain parameter instance from this builder. */
      public TransferData build() {
        return new TransferData(this.amount, this.destination);
      }

      /**
       * The amount transferred to the destination account, if specified. By default, the entire
       * charge amount is transferred to the destination account.
       */
      public Builder setAmount(Long amount) {
        this.amount = amount;
        return this;
      }

      /** ID of an existing, connected Stripe account. */
      public Builder setDestination(String destination) {
        this.destination = destination;
        return this;
      }
    }
  }
}
