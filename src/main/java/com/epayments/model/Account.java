package com.epayments.model;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.epayments.model.customer.Customer;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

/**
 * The type Account.
 */
@Document(collection = "account")
public class Account {

	@Id
	private ObjectId _id;

	@NotNull
	private String customerId;

	@NotNull
	private String title;

	private String description;
	
	@NotNull
	private String accountNo;

	private Customer customer;

	@NotNull
	@DecimalMin("0")
	private BigDecimal initialBalance;
	
	private String status;

    /**
     * Instantiates a new Account.
     */
    public Account() {
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
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
		return title;
	}

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
		this.title = title;
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
     * Gets account id.
     *
     * @return the account id
     */
    public String getAccountNo() {
		return accountNo;
	}

    /**
     * Sets account id.
     *
     * @param accountNo the account id
     */
    public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
		return status;
	}

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(String status) {
		this.status = status;
	}


    /**
     * Gets id.
     *
     * @return the id
     */
    public ObjectId get_id() {
		return _id;
	}

    /**
     * Sets id.
     *
     * @param _id the id
     */
    public void set_id(ObjectId _id) {
		this._id = _id;
	}

    /**
     * Gets customer.
     *
     * @return the customer
     */
    public Customer getCustomer() {
		return customer;
	}

    /**
     * Sets customer.
     *
     * @param customer the customer
     */
    public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
