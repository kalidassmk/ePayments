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
	@DecimalMin("0")
	private BigDecimal initialBalance;

	private CustomerInfo customerInfo;

	/**
	 * Instantiates a new Create account request.
	 */
	public CreateAccountRequest() {
	}

	/**
	 * Instantiates a new Create account request.
	 *
	 * @param customerId     the customer id
	 * @param description    the description
	 * @param initialBalance the initial balance
	 * @param customerInfo   the customer info
	 */
	public CreateAccountRequest(String customerId, String description, BigDecimal initialBalance, CustomerInfo customerInfo) {
		this.customerId = customerId;
		this.description = description;
		this.initialBalance = initialBalance;
		this.customerInfo = customerInfo;
	}

	/**
	 * Gets customer id.
	 *
	 * @return the customer id
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * Sets customer id.
	 *
	 * @param customerId the customer id
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * Gets description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
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
	 * Gets initial balance.
	 *
	 * @return the initial balance
	 */
	public BigDecimal getInitialBalance() {
		return initialBalance;
	}

	/**
	 * Sets initial balance.
	 *
	 * @param initialBalance the initial balance
	 */
	public void setInitialBalance(BigDecimal initialBalance) {
		this.initialBalance = initialBalance;
	}

	/**
	 * Gets customer info.
	 *
	 * @return the customer info
	 */
	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}

	/**
	 * Sets customer info.
	 *
	 * @param customerInfo the customer info
	 */
	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}
}
