package com.epayments.model;

import java.math.BigDecimal;

/**
 * The type Account response.
 */


public class AccountResponse {

    private String customerId;

    private String accountNo;

    private BigDecimal balance;

    private String firstName;

    private String lastName;

    private String dateOfBirth;

    private String phoneNumber;

    private String currencyCode;


    /**
     * Instantiates a new Account response.
     */
    public AccountResponse() {
    }


    /**
     * Instantiates a new Account response.
     *
     * @param customerId   the customer id
     * @param accountNo    the account no
     * @param balance      the balance
     * @param firstName    the first name
     * @param lastName     the last name
     * @param dateOfBirth  the date of birth
     * @param phoneNumber  the phone number
     * @param currencyCode the currency code
     */
    public AccountResponse(String customerId, String accountNo, BigDecimal balance, String firstName, String lastName, String dateOfBirth, String phoneNumber, String currencyCode) {
        this.customerId = customerId;
        this.accountNo = accountNo;
        this.balance = balance;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.currencyCode = currencyCode;
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
     * Gets account no.
     *
     * @return the account no
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * Sets account no.
     *
     * @param accountNo the account no
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    /**
     * Gets balance.
     *
     * @return the balance
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * Sets balance.
     *
     * @param balance the balance
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets date of birth.
     *
     * @return the date of birth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets date of birth.
     *
     * @param dateOfBirth the date of birth
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets currency code.
     *
     * @return the currency code
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets currency code.
     *
     * @param currencyCode the currency code
     */
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
