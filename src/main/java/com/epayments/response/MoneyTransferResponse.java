package com.epayments.response;

/**
 * The type Money transfer response.
 */
public class MoneyTransferResponse {

    private String transactionId;


    private EPaymentState EPaymentState;

    /**
     * Instantiates a new Money transfer response.
     */
    public MoneyTransferResponse() {
    }

    /**
     * Instantiates a new Money transfer response.
     *
     * @param transactionId the money transfer id
     * @param EPaymentState the transfer state
     */
    public MoneyTransferResponse(String transactionId, EPaymentState EPaymentState) {
        this.transactionId = transactionId;
        this.EPaymentState = EPaymentState;
    }

    /**
     * Gets money transfer id.
     *
     * @return the money transfer id
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Sets money transfer id.
     *
     * @param transactionId the money transfer id
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * Gets transfer state.
     *
     * @return the transfer state
     */
    public EPaymentState getEPaymentState() {
        return EPaymentState;
    }

    /**
     * Sets transfer state.
     *
     * @param EPaymentState the transfer state
     */
    public void setEPaymentState(EPaymentState EPaymentState) {
        this.EPaymentState = EPaymentState;
    }
}
