// Generated by com.stripe.generator.entity.SdkBuilder

package com.stripe.param.issuing;

import com.google.gson.annotations.SerializedName;
import com.stripe.net.ApiRequestParams;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class AuthorizationListParams extends ApiRequestParams {
  /** Only return issuing transactions that belong to the given card. */
  @SerializedName("card")
  String card;

  /** Only return authorizations belonging to the given cardholder. */
  @SerializedName("cardholder")
  String cardholder;

  /** Only return authorizations that were created during the given date interval. */
  @SerializedName("created")
  Object created;

  /**
   * A cursor for use in pagination. `ending_before` is an object ID that defines your place in the
   * list. For instance, if you make a list request and receive 100 objects, starting with
   * `obj_bar`, your subsequent call can include `ending_before=obj_bar` in order to fetch the
   * previous page of the list.
   */
  @SerializedName("ending_before")
  String endingBefore;

  /** Specifies which fields in the response should be expanded. */
  @SerializedName("expand")
  List<String> expand;

  /**
   * A limit on the number of objects to be returned. Limit can range between 1 and 100, and the
   * default is 10.
   */
  @SerializedName("limit")
  Long limit;

  /**
   * A cursor for use in pagination. `starting_after` is an object ID that defines your place in the
   * list. For instance, if you make a list request and receive 100 objects, ending with `obj_foo`,
   * your subsequent call can include `starting_after=obj_foo` in order to fetch the next page of
   * the list.
   */
  @SerializedName("starting_after")
  String startingAfter;

  /** Only return authorizations with the given status. One of pending, closed, or reversed. */
  @SerializedName("status")
  Status status;

  private AuthorizationListParams(
      String card,
      String cardholder,
      Object created,
      String endingBefore,
      List<String> expand,
      Long limit,
      String startingAfter,
      Status status) {
    this.card = card;
    this.cardholder = cardholder;
    this.created = created;
    this.endingBefore = endingBefore;
    this.expand = expand;
    this.limit = limit;
    this.startingAfter = startingAfter;
    this.status = status;
  }

  public static Builder builder() {
    return new com.stripe.param.issuing.AuthorizationListParams.Builder();
  }

  public static class Builder {
    private String card;

    private String cardholder;

    private Object created;

    private String endingBefore;

    private List<String> expand;

    private Long limit;

    private String startingAfter;

    private Status status;

    /** Finalize and obtain parameter instance from this builder. */
    public AuthorizationListParams build() {
      return new AuthorizationListParams(
          this.card,
          this.cardholder,
          this.created,
          this.endingBefore,
          this.expand,
          this.limit,
          this.startingAfter,
          this.status);
    }

    /**
     * Add an element to `expand` list. A list is initialized for the first call, and subsequent
     * calls adds additional elements to the original list. See {@link
     * AuthorizationListParams#expand} for the field documentation.
     */
    public Builder addExpand(String element) {
      if (this.expand == null) {
        this.expand = new ArrayList<>();
      }
      this.expand.add(element);
      return this;
    }

    /** Only return authorizations belonging to the given cardholder. */
    public Builder setCardholder(String cardholder) {
      this.cardholder = cardholder;
      return this;
    }

    /** Only return issuing transactions that belong to the given card. */
    public Builder setCard(String card) {
      this.card = card;
      return this;
    }

    /** Only return authorizations that were created during the given date interval. */
    public Builder setCreated(Created created) {
      this.created = created;
      return this;
    }

    /** Only return authorizations that were created during the given date interval. */
    public Builder setCreated(Long created) {
      this.created = created;
      return this;
    }

    /**
     * A cursor for use in pagination. `ending_before` is an object ID that defines your place in
     * the list. For instance, if you make a list request and receive 100 objects, starting with
     * `obj_bar`, your subsequent call can include `ending_before=obj_bar` in order to fetch the
     * previous page of the list.
     */
    public Builder setEndingBefore(String endingBefore) {
      this.endingBefore = endingBefore;
      return this;
    }

    /**
     * A limit on the number of objects to be returned. Limit can range between 1 and 100, and the
     * default is 10.
     */
    public Builder setLimit(Long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * A cursor for use in pagination. `starting_after` is an object ID that defines your place in
     * the list. For instance, if you make a list request and receive 100 objects, ending with
     * `obj_foo`, your subsequent call can include `starting_after=obj_foo` in order to fetch the
     * next page of the list.
     */
    public Builder setStartingAfter(String startingAfter) {
      this.startingAfter = startingAfter;
      return this;
    }

    /** Only return authorizations with the given status. One of pending, closed, or reversed. */
    public Builder setStatus(Status status) {
      this.status = status;
      return this;
    }
  }

  @Getter
  public static class Created {
    /** Minimum value to filter by (exclusive). */
    @SerializedName("gt")
    Long gt;

    /** Minimum value to filter by (inclusive). */
    @SerializedName("gte")
    Long gte;

    /** Maximum value to filter by (exclusive). */
    @SerializedName("lt")
    Long lt;

    /** Maximum value to filter by (inclusive). */
    @SerializedName("lte")
    Long lte;

    private Created(Long gt, Long gte, Long lt, Long lte) {
      this.gt = gt;
      this.gte = gte;
      this.lt = lt;
      this.lte = lte;
    }

    public static Builder builder() {
      return new com.stripe.param.issuing.AuthorizationListParams.Created.Builder();
    }

    public static class Builder {
      private Long gt;

      private Long gte;

      private Long lt;

      private Long lte;

      /** Finalize and obtain parameter instance from this builder. */
      public Created build() {
        return new Created(this.gt, this.gte, this.lt, this.lte);
      }

      /** Minimum value to filter by (inclusive). */
      public Builder setGte(Long gte) {
        this.gte = gte;
        return this;
      }

      /** Minimum value to filter by (exclusive). */
      public Builder setGt(Long gt) {
        this.gt = gt;
        return this;
      }

      /** Maximum value to filter by (inclusive). */
      public Builder setLte(Long lte) {
        this.lte = lte;
        return this;
      }

      /** Maximum value to filter by (exclusive). */
      public Builder setLt(Long lt) {
        this.lt = lt;
        return this;
      }
    }
  }

  public enum Status implements ApiRequestParams.Enum {
    @SerializedName("closed")
    CLOSED("closed"),

    @SerializedName("pending")
    PENDING("pending"),

    @SerializedName("reversed")
    REVERSED("reversed");

    @Getter private final String value;

    Status(String value) {
      this.value = value;
    }
  }
}
