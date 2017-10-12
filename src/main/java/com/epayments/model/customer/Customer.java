package com.epayments.model.customer;

/**
 * The type Customer response.
 */
public class Customer {

	private String customerId;

	private CustomerInfo customerInfo;

	/**
	 * Instantiates a new Customer.
	 */
	public Customer() {
	}

	/**
	 * Instantiates a new Customer.
	 *
	 * @param customerId   the customer id
	 * @param customerInfo the customer info
	 */
	public Customer(String customerId, CustomerInfo customerInfo) {
		this.customerId = customerId;
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
