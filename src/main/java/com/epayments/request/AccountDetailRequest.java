package com.epayments.request;

import javax.validation.constraints.NotNull;

/**
 * Created by kamahalingam on 10/12/2017.
 */
public class AccountDetailRequest {

    @NotNull
    private String customerId;

    private String accountNo;


    /**
     * Instantiates a new Account detail request.
     */
    public AccountDetailRequest() {
    }

    /**
     * Instantiates a new Account detail request.
     *
     * @param customerId the customer id
     * @param accountNo  the account no
     */
    public AccountDetailRequest(String customerId, String accountNo) {
        this.customerId = customerId;
        this.accountNo = accountNo;
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
}
