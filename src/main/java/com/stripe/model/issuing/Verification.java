// Generated by com.stripe.generator.entity.SdkBuilder

package com.stripe.model.issuing;

import com.google.gson.annotations.SerializedName;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.HasId;
import com.stripe.net.ApiResource;
import com.stripe.net.RequestOptions;
import com.stripe.param.issuing.VerificationCreateParams;
import java.util.Map;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Verification extends ApiResource implements HasId {
  /** The id of the `Card` on which the verification was requested. */
  @SerializedName("card")
  String card;

  /** Time at which the object was created. Measured in seconds since the Unix epoch. */
  @SerializedName("created")
  Long created;

  /** Timestamp of the expiry for that verification. */
  @SerializedName("expires_at")
  Long expiresAt;

  /** Unique identifier for the object. */
  @Getter(onMethod = @__({@Override}))
  @SerializedName("id")
  String id;

  /** String representing the object's type. Objects of the same type share the same value. */
  @SerializedName("object")
  String object;

  /** The scope of the verification. */
  @SerializedName("scope")
  String scope;

  /** The method by which the cardholder will be sent a one-time password. */
  @SerializedName("verification_method")
  String verificationMethod;

  /** Some actions (eg: updating a PIN) need confirmation from the cardholder. */
  public static Verification create(Map<String, Object> params) throws StripeException {
    return create(params, (RequestOptions) null);
  }

  /** Some actions (eg: updating a PIN) need confirmation from the cardholder. */
  public static Verification create(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url = String.format("%s%s", Stripe.getApiBase(), "/v1/issuing/verifications");
    return request(ApiResource.RequestMethod.POST, url, params, Verification.class, options);
  }

  /** Some actions (eg: updating a PIN) need confirmation from the cardholder. */
  public static Verification create(VerificationCreateParams params) throws StripeException {
    return create(params, (RequestOptions) null);
  }

  /** Some actions (eg: updating a PIN) need confirmation from the cardholder. */
  public static Verification create(VerificationCreateParams params, RequestOptions options)
      throws StripeException {
    String url = String.format("%s%s", Stripe.getApiBase(), "/v1/issuing/verifications");
    return request(ApiResource.RequestMethod.POST, url, params, Verification.class, options);
  }
}
