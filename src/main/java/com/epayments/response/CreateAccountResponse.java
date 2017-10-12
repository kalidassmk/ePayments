package com.epayments.response;

/**
 * The type Create account response.
 */
public class CreateAccountResponse {

    private String accountNo;

    private EPaymentState status;

    /**
     * Instantiates a new Create account response.
     */
    public CreateAccountResponse() {
    }

    /**
     * Instantiates a new Create account response.
     *
     * @param accountNo the account no
     * @param status    the status
     */
    public CreateAccountResponse(String accountNo, EPaymentState status) {
        this.accountNo = accountNo;
        this.status = status;
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
     * Gets status.
     *
     * @return the status
     */
    public EPaymentState getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(EPaymentState status) {
        this.status = status;
    }
}
