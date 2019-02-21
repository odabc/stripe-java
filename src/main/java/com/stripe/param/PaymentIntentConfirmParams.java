// Generated by com.stripe.generator.entity.SdkBuilder

package com.stripe.param;

import com.google.gson.annotations.SerializedName;
import com.stripe.net.ApiRequestParams;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class PaymentIntentConfirmParams extends ApiRequestParams {
  /** The client secret of the PaymentIntent. */
  @SerializedName("client_secret")
  String clientSecret;

  /** Specifies which fields in the response should be expanded. */
  @SerializedName("expand")
  List<String> expand;

  /** The [Level III data](/docs/level3) associated with this payment. */
  @SerializedName("level3")
  Level3 level3;

  /** The list of payment method types (e.g. card) that this PaymentIntent is allowed to use. */
  @SerializedName("payment_method_types")
  List<String> paymentMethodTypes;

  /** Email address that the receipt for the resulting payment will be sent to. */
  @SerializedName("receipt_email")
  String receiptEmail;

  /**
   * The URL to redirect your customer back to after they authenticate or cancel their payment on
   * the payment method's app or site. If you'd prefer to redirect to a mobile application, you can
   * alternatively supply an application URI scheme. This parameter is only used for cards and other
   * redirect-based payment methods.
   */
  @SerializedName("return_url")
  String returnUrl;

  /**
   * Set to `true` to save this PaymentIntent's payment method to the associated Customer, if the
   * payment method is not already attached. This parameter only applies to the payment method
   * passed in the same request or the current payment method attached to the PaymentIntent and must
   * be specified again if a new payment method is added.
   */
  @SerializedName("save_payment_method")
  Boolean savePaymentMethod;

  /** Shipping information for this PaymentIntent. */
  @SerializedName("shipping")
  Shipping shipping;

  /** ID of the Source object to attach to this PaymentIntent. */
  @SerializedName("source")
  String source;

  private PaymentIntentConfirmParams(
      String clientSecret,
      List<String> expand,
      Level3 level3,
      List<String> paymentMethodTypes,
      String receiptEmail,
      String returnUrl,
      Boolean savePaymentMethod,
      Shipping shipping,
      String source) {
    this.clientSecret = clientSecret;
    this.expand = expand;
    this.level3 = level3;
    this.paymentMethodTypes = paymentMethodTypes;
    this.receiptEmail = receiptEmail;
    this.returnUrl = returnUrl;
    this.savePaymentMethod = savePaymentMethod;
    this.shipping = shipping;
    this.source = source;
  }

  public static Builder builder() {
    return new com.stripe.param.PaymentIntentConfirmParams.Builder();
  }

  public static class Builder {
    private String clientSecret;

    private List<String> expand;

    private Level3 level3;

    private List<String> paymentMethodTypes;

    private String receiptEmail;

    private String returnUrl;

    private Boolean savePaymentMethod;

    private Shipping shipping;

    private String source;

    /** Finalize and obtain parameter instance from this builder. */
    public PaymentIntentConfirmParams build() {
      return new PaymentIntentConfirmParams(
          this.clientSecret,
          this.expand,
          this.level3,
          this.paymentMethodTypes,
          this.receiptEmail,
          this.returnUrl,
          this.savePaymentMethod,
          this.shipping,
          this.source);
    }

    /**
     * Add an element to `expand` list. A list is initialized for the first call, and subsequent
     * calls adds additional elements to the original list. See {@link
     * PaymentIntentConfirmParams#expand} for the field documentation.
     */
    public Builder addExpand(String element) {
      if (this.expand == null) {
        this.expand = new ArrayList<>();
      }
      this.expand.add(element);
      return this;
    }

    /**
     * Add an element to `paymentMethodTypes` list. A list is initialized for the first call, and
     * subsequent calls adds additional elements to the original list. See {@link
     * PaymentIntentConfirmParams#paymentMethodTypes} for the field documentation.
     */
    public Builder addPaymentMethodTypes(String element) {
      if (this.paymentMethodTypes == null) {
        this.paymentMethodTypes = new ArrayList<>();
      }
      this.paymentMethodTypes.add(element);
      return this;
    }

    /** The client secret of the PaymentIntent. */
    public Builder setClientSecret(String clientSecret) {
      this.clientSecret = clientSecret;
      return this;
    }

    /** The [Level III data](/docs/level3) associated with this payment. */
    public Builder setLevel3(Level3 level3) {
      this.level3 = level3;
      return this;
    }

    /** Email address that the receipt for the resulting payment will be sent to. */
    public Builder setReceiptEmail(String receiptEmail) {
      this.receiptEmail = receiptEmail;
      return this;
    }

    /**
     * The URL to redirect your customer back to after they authenticate or cancel their payment on
     * the payment method's app or site. If you'd prefer to redirect to a mobile application, you
     * can alternatively supply an application URI scheme. This parameter is only used for cards and
     * other redirect-based payment methods.
     */
    public Builder setReturnUrl(String returnUrl) {
      this.returnUrl = returnUrl;
      return this;
    }

    /**
     * Set to `true` to save this PaymentIntent's payment method to the associated Customer, if the
     * payment method is not already attached. This parameter only applies to the payment method
     * passed in the same request or the current payment method attached to the PaymentIntent and
     * must be specified again if a new payment method is added.
     */
    public Builder setSavePaymentMethod(Boolean savePaymentMethod) {
      this.savePaymentMethod = savePaymentMethod;
      return this;
    }

    /** Shipping information for this PaymentIntent. */
    public Builder setShipping(Shipping shipping) {
      this.shipping = shipping;
      return this;
    }

    /** ID of the Source object to attach to this PaymentIntent. */
    public Builder setSource(String source) {
      this.source = source;
      return this;
    }
  }

  @Getter
  public static class Level3 {
    /**
     * An alphanumeric string, at most 17 characters long. Customers sometimes are required to
     * supply this, depending on their card.
     */
    @SerializedName("customer_reference")
    String customerReference;

    /** An array of items that were purchased. */
    @SerializedName("line_items")
    List<LineItems> lineItems;

    /**
     * An alphanumeric string, at most 25 characters long. Unique value assigned by the user that
     * specifies the order. Also known as an 'Order ID'.
     */
    @SerializedName("merchant_reference")
    String merchantReference;

    /** Customer's US shipping address ZIP code. */
    @SerializedName("shipping_address_zip")
    String shippingAddressZip;

    /** The cost in %s it took to ship the item, if the cost was given to the customer. */
    @SerializedName("shipping_amount")
    Long shippingAmount;

    /** Merchant's US shipping address ZIP code. */
    @SerializedName("shipping_from_zip")
    String shippingFromZip;

    private Level3(
        String customerReference,
        List<LineItems> lineItems,
        String merchantReference,
        String shippingAddressZip,
        Long shippingAmount,
        String shippingFromZip) {
      this.customerReference = customerReference;
      this.lineItems = lineItems;
      this.merchantReference = merchantReference;
      this.shippingAddressZip = shippingAddressZip;
      this.shippingAmount = shippingAmount;
      this.shippingFromZip = shippingFromZip;
    }

    public static Builder builder() {
      return new com.stripe.param.PaymentIntentConfirmParams.Level3.Builder();
    }

    public static class Builder {
      private String customerReference;

      private List<LineItems> lineItems;

      private String merchantReference;

      private String shippingAddressZip;

      private Long shippingAmount;

      private String shippingFromZip;

      /** Finalize and obtain parameter instance from this builder. */
      public Level3 build() {
        return new Level3(
            this.customerReference,
            this.lineItems,
            this.merchantReference,
            this.shippingAddressZip,
            this.shippingAmount,
            this.shippingFromZip);
      }

      /**
       * Add an element to `lineItems` list. A list is initialized for the first call, and
       * subsequent calls adds additional elements to the original list. See {@link
       * Level3#lineItems} for the field documentation.
       */
      public Builder addLineItems(LineItems element) {
        if (this.lineItems == null) {
          this.lineItems = new ArrayList<>();
        }
        this.lineItems.add(element);
        return this;
      }

      /**
       * An alphanumeric string, at most 17 characters long. Customers sometimes are required to
       * supply this, depending on their card.
       */
      public Builder setCustomerReference(String customerReference) {
        this.customerReference = customerReference;
        return this;
      }

      /**
       * An alphanumeric string, at most 25 characters long. Unique value assigned by the user that
       * specifies the order. Also known as an 'Order ID'.
       */
      public Builder setMerchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
        return this;
      }

      /** Customer's US shipping address ZIP code. */
      public Builder setShippingAddressZip(String shippingAddressZip) {
        this.shippingAddressZip = shippingAddressZip;
        return this;
      }

      /** The cost in %s it took to ship the item, if the cost was given to the customer. */
      public Builder setShippingAmount(Long shippingAmount) {
        this.shippingAmount = shippingAmount;
        return this;
      }

      /** Merchant's US shipping address ZIP code. */
      public Builder setShippingFromZip(String shippingFromZip) {
        this.shippingFromZip = shippingFromZip;
        return this;
      }
    }

    @Getter
    public static class LineItems {
      /**
       * Non-negative integer. The amount an item was discounted (if there was a sale, for example)
       */
      @SerializedName("discount_amount")
      Long discountAmount;

      /** At most 12 characters that uniquely identifies the product. */
      @SerializedName("product_code")
      String productCode;

      /** At most 25 characters long. Description of the product. */
      @SerializedName("product_description")
      String productDescription;

      /** Non-negative integer. The number of items of this type sold. */
      @SerializedName("quantity")
      Long quantity;

      /** Non-negative integer. The amount of tax this item had added to it, in cents. */
      @SerializedName("tax_amount")
      Long taxAmount;

      /** Non-negative integer. Cost of the product, in cents. */
      @SerializedName("unit_cost")
      Long unitCost;

      private LineItems(
          Long discountAmount,
          String productCode,
          String productDescription,
          Long quantity,
          Long taxAmount,
          Long unitCost) {
        this.discountAmount = discountAmount;
        this.productCode = productCode;
        this.productDescription = productDescription;
        this.quantity = quantity;
        this.taxAmount = taxAmount;
        this.unitCost = unitCost;
      }

      public static Builder builder() {
        return new com.stripe.param.PaymentIntentConfirmParams.Level3.LineItems.Builder();
      }

      public static class Builder {
        private Long discountAmount;

        private String productCode;

        private String productDescription;

        private Long quantity;

        private Long taxAmount;

        private Long unitCost;

        /** Finalize and obtain parameter instance from this builder. */
        public LineItems build() {
          return new LineItems(
              this.discountAmount,
              this.productCode,
              this.productDescription,
              this.quantity,
              this.taxAmount,
              this.unitCost);
        }

        /**
         * Non-negative integer. The amount an item was discounted (if there was a sale, for
         * example)
         */
        public Builder setDiscountAmount(Long discountAmount) {
          this.discountAmount = discountAmount;
          return this;
        }

        /** At most 12 characters that uniquely identifies the product. */
        public Builder setProductCode(String productCode) {
          this.productCode = productCode;
          return this;
        }

        /** At most 25 characters long. Description of the product. */
        public Builder setProductDescription(String productDescription) {
          this.productDescription = productDescription;
          return this;
        }

        /** Non-negative integer. The number of items of this type sold. */
        public Builder setQuantity(Long quantity) {
          this.quantity = quantity;
          return this;
        }

        /** Non-negative integer. The amount of tax this item had added to it, in cents. */
        public Builder setTaxAmount(Long taxAmount) {
          this.taxAmount = taxAmount;
          return this;
        }

        /** Non-negative integer. Cost of the product, in cents. */
        public Builder setUnitCost(Long unitCost) {
          this.unitCost = unitCost;
          return this;
        }
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
      return new com.stripe.param.PaymentIntentConfirmParams.Shipping.Builder();
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
        return new com.stripe.param.PaymentIntentConfirmParams.Shipping.Address.Builder();
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
}
