package com.epayments.response;

/**
 * The enum Transfer state.
 */
public enum EPaymentState {
    /**
     * New transfer state.
     */
    NEW, /**
     * Initial transfer state.
     */
    INITIAL, /**
     * Debited transfer state.
     */
    FAILED, /**
     * Completed transfer state.
     */
    TRANSACTION_COMPLETED, /**
     * Failed due to insufficient funds transfer state.
     */
    FAILED_DUE_TO_INSUFFICIENT_FUNDS,

    /**
     * Source account not active transfer state.
     */
    SOURCE_ACCOUNT_NOT_ACTIVE,

    /**
     * Destination account not active transfer state.
     */
    DESTINATION_ACCOUNT_NOT_ACTIVE,

    /**
     * Account created e payment state.
     */
    ACCOUNT_CREATED

	}
