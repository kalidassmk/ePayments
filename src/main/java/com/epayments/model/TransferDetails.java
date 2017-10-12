package com.epayments.model;

import com.epayments.response.EPaymentState;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

/**
 * The type Transfer details.
 */
@Document(collection = "transferdetails")
public class TransferDetails {

    @Id
    private ObjectId _id;

    private String transactionId;
    private String fromAccountNo;
    private String toAccountNo;
    private BigDecimal amount;
    private Date date;
    private String description;
    EPaymentState EPaymentState;
    private String sourceCurrencyCode;
    private String destinationCurrencyCode;


    /**
     * Instantiates a new Transfer details.
     */
    public TransferDetails() {
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

    /**
     * Gets fromaccount no.
     *
     * @return the fromaccount no
     */
    public String getFromAccountNo() {
        return fromAccountNo;
    }

    /**
     * Sets fromaccount no.
     *
     * @param fromAccountNo the fromaccount no
     */
    public void setFromAccountNo(String fromAccountNo) {
        this.fromAccountNo = fromAccountNo;
    }

    /**
     * Gets toaccount no.
     *
     * @return the toaccount no
     */
    public String getToAccountNo() {
        return toAccountNo;
    }

    /**
     * Sets toaccount no.
     *
     * @param toAccountNo the toaccount no
     */
    public void setToAccountNo(String toAccountNo) {
        this.toAccountNo = toAccountNo;
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
     * Sets amount.
     *
     * @param amount the amount
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
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

    public String getSourceCurrencyCode() {
        return sourceCurrencyCode;
    }

    public void setSourceCurrencyCode(String sourceCurrencyCode) {
        this.sourceCurrencyCode = sourceCurrencyCode;
    }

    public String getDestinationCurrencyCode() {
        return destinationCurrencyCode;
    }

    public void setDestinationCurrencyCode(String destinationCurrencyCode) {
        this.destinationCurrencyCode = destinationCurrencyCode;
    }
}
