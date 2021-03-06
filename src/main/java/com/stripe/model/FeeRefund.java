package com.stripe.model;

import com.stripe.exception.StripeException;
import com.stripe.net.ApiResource;
import com.stripe.net.RequestOptions;

import java.util.Map;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class FeeRefund extends ApiResource implements MetadataStore<ApplicationFee>, HasId {
  @Getter(onMethod = @__({@Override})) String id;
  String object;
  Long amount;
  @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE)
      ExpandableField<BalanceTransaction> balanceTransaction;
  String currency;
  Long created;
  @Getter(AccessLevel.NONE) @Setter(AccessLevel.NONE) ExpandableField<ApplicationFee> fee;
  @Getter(onMethod = @__({@Override})) Map<String, String> metadata;

  // <editor-fold desc="balanceTransaction">
  public String getBalanceTransaction() {
    return (this.balanceTransaction != null) ? this.balanceTransaction.getId() : null;
  }

  public void setBalanceTransaction(String balanceTransactionId) {
    this.balanceTransaction = setExpandableFieldId(balanceTransactionId, this.balanceTransaction);
  }

  public BalanceTransaction getBalanceTransactionObject() {
    return (this.balanceTransaction != null) ? this.balanceTransaction.getExpanded() : null;
  }

  public void setBalanceTransactionObject(BalanceTransaction c) {
    this.balanceTransaction = new ExpandableField<>(c.getId(), c);
  }
  // </editor-fold>

  // <editor-fold desc="fee">
  public String getFee() {
    return (this.fee != null) ? this.fee.getId() : null;
  }

  public void setFee(String feeId) {
    this.fee = setExpandableFieldId(feeId, this.fee);
  }

  public ApplicationFee getFeeObject() {
    return (this.fee != null) ? this.fee.getExpanded() : null;
  }

  public void setFeeObject(ApplicationFee c) {
    this.fee = new ExpandableField<>(c.getId(), c);
  }
  // </editor-fold>

  // <editor-fold desc="update">
  /**
   * Update an application fee refund.
   */
  @Override
  public FeeRefund update(Map<String, Object> params) throws StripeException {
    return update(params, (RequestOptions) null);
  }

  /**
   * Update an application fee refund.
   */
  @Override
  public FeeRefund update(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    return request(RequestMethod.POST, this.getInstanceUrl(), params, FeeRefund.class, options);
  }
  // </editor-fold>

  protected String getInstanceUrl() {
    if (this.fee != null) {
      return String.format("%s/%s/refunds/%s", classUrl(ApplicationFee.class), this.getFee(),
          this.getId());
    }
    return null;
  }
}
