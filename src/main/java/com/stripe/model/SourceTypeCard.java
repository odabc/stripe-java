// Generated by com.stripe.generator.entity.SdkBuilder

package com.stripe.model;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class SourceTypeCard extends StripeObject {
  @SerializedName("address_line1_check")
  String addressLine1Check;

  @SerializedName("address_zip_check")
  String addressZipCheck;

  @SerializedName("brand")
  String brand;

  @SerializedName("country")
  String country;

  @SerializedName("cvc_check")
  String cvcCheck;

  @SerializedName("dynamic_last4")
  String dynamicLast4;

  @SerializedName("exp_month")
  Long expMonth;

  @SerializedName("exp_year")
  Long expYear;

  @SerializedName("fingerprint")
  String fingerprint;

  @SerializedName("funding")
  String funding;

  @SerializedName("last4")
  String last4;

  @SerializedName("name")
  String name;

  @SerializedName("skip_validation")
  Boolean skipValidation;

  @SerializedName("three_d_secure")
  String threeDSecure;

  @SerializedName("tokenization_method")
  String tokenizationMethod;
}