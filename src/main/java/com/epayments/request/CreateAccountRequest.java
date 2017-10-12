package com.epayments.request;

import com.epayments.model.customer.CustomerInfo;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * The type Create account request.
 */
public class CreateAccountRequest {

	@NotNull
	private String customerId;

	@NotNull
	private String description;

	@NotNull
	private String currencyCode;

	@NotNull
	@DecimalMin("0")
	private BigDecimal initialBalance;

	private CustomerInfo customerInfo;

	/**
	 * Instantiates a new Create account request.
	 */
	public CreateAccountRequest() {
	}

	public CreateAccountRequest(String customerId, String description, String currencyCode, BigDecimal initialBalance, CustomerInfo customerInfo) {
		this.customerId = customerId;
		this.description = description;
		this.currencyCode = currencyCode;
		this.initialBalance = initialBalance;
		this.customerInfo = customerInfo;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public BigDecimal getInitialBalance() {
		return initialBalance;
	}

	public void setInitialBalance(BigDecimal initialBalance) {
		this.initialBalance = initialBalance;
	}

	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}
}
