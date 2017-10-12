package com.epayments.request;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * The type Money transfer request.
 */
public class MoneyTransferRequest {
	

	  @NotNull
	  private String fromaccountNo;

	  @NotNull
	  private String toaccountNo;

	  @DecimalMin("0.01")
	  private BigDecimal amount;

	  private String description;

    /**
     * Instantiates a new Money transfer request.
     */
    public MoneyTransferRequest() {
	  }

    /**
     * Instantiates a new Money transfer request.
     *
     * @param fromaccountNo the from account id
     * @param toaccountNo   the to account id
     * @param amount        the amount
     * @param description   the description
     */
    public MoneyTransferRequest(String fromaccountNo, String toaccountNo, BigDecimal amount, String description) {
	    this.fromaccountNo = fromaccountNo;
	    this.toaccountNo = toaccountNo;
	    this.amount = amount;
	    this.description = description;
	  }

    /**
     * Sets from account id.
     *
     * @param fromaccountNo the from account id
     */
    public void setFromaccountNo(String fromaccountNo) {
	    this.fromaccountNo = fromaccountNo;
	  }

    /**
     * Sets to account id.
     *
     * @param toaccountNo the to account id
     */
    public void setToaccountNo(String toaccountNo) {
	    this.toaccountNo = toaccountNo;
	  }

    /**
     * Sets amount.
     *
     * @param amount the amount
     */
    public void setAmount(BigDecimal amount) {
	    this.amount = amount;
	  }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
	    this.description = description;
	  }

    /**
     * Gets from account id.
     *
     * @return the from account id
     */
    public String getFromaccountNo() {
	    return fromaccountNo;
	  }

    /**
     * Gets to account id.
     *
     * @return the to account id
     */
    public String getToaccountNo() {
	    return toaccountNo;
	  }

    /**
     * Gets amount.
     *
     * @return the amount
     */
    public BigDecimal getAmount() {
	    return amount;
	  }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
	    return description;
	  }

}
