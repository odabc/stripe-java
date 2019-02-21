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
public class TransferReversalUpdateParams extends ApiRequestParams {
  /** Specifies which fields in the response should be expanded. */
  @SerializedName("expand")
  List<String> expand;

  /**
   * Set of key-value pairs that you can attach to an object. This can be useful for storing
   * additional information about the object in a structured format. Individual keys can be unset by
   * posting an empty value to them. All keys can be unset by posting an empty value to `metadata`.
   */
  @SerializedName("metadata")
  Map<String, String> metadata;

  private TransferReversalUpdateParams(List<String> expand, Map<String, String> metadata) {
    this.expand = expand;
    this.metadata = metadata;
  }

  public static Builder builder() {
    return new com.stripe.param.TransferReversalUpdateParams.Builder();
  }

  public static class Builder {
    private List<String> expand;

    private Map<String, String> metadata;

    /** Finalize and obtain parameter instance from this builder. */
    public TransferReversalUpdateParams build() {
      return new TransferReversalUpdateParams(this.expand, this.metadata);
    }

    /**
     * Add an element to `expand` list. A list is initialized for the first call, and subsequent
     * calls adds additional elements to the original list. See {@link
     * TransferReversalUpdateParams#expand} for the field documentation.
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
     * TransferReversalUpdateParams#metadata} for the field documentation.
     */
    public Builder putMetadata(String key, String value) {
      if (this.metadata == null) {
        this.metadata = new HashMap<>();
      }
      this.metadata.put(key, value);
      return this;
    }
  }
}
