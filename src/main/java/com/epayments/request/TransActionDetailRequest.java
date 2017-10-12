package com.epayments.request;

import javax.validation.constraints.NotNull;

/**
 * Created by kamahalingam on 10/12/2017.
 */
public class TransActionDetailRequest {

    @NotNull
    private String customerId;

    private String accountNo;

    private String transactionId;

    /**
     * Instantiates a new Trans action detail request.
     */
    public TransActionDetailRequest() {
    }

    /**
     * Instantiates a new Trans action detail request.
     *
     * @param customerId    the customer id
     * @param accountNo     the account no
     * @param transactionId the transaction id
     */
    public TransActionDetailRequest(String customerId, String accountNo, String transactionId) {
        this.customerId = customerId;
        this.accountNo = accountNo;
        this.transactionId = transactionId;
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
     * Gets transaction id.
     *
     * @return the transaction id
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Sets transaction id.
     *
     * @param transactionId the transaction id
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
