package com.epayments.exception;

/**
 * The type Async exception.
 *
 * @author Kalidass Mahalingam
 */
public class AsyncException extends Throwable {
	
	private static final long serialVersionUID = 1L;
	
	private String message;

    /**
     * Instantiates a new Async exception.
     */
    public AsyncException() {
		super();
	}

    /**
     * Instantiates a new Async exception.
     *
     * @param message            the message
     * @param cause              the cause
     * @param enableSuppression  the enable suppression
     * @param writableStackTrace the writable stack trace
     */
    public AsyncException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

    /**
     * Instantiates a new Async exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public AsyncException(String message, Throwable cause) {
		super(message, cause);
	}

    /**
     * Instantiates a new Async exception.
     *
     * @param message the message
     */
    public AsyncException(String message) {
		super(message);
	}

    /**
     * Instantiates a new Async exception.
     *
     * @param cause the cause
     */
    public AsyncException(Throwable cause) {
		super(cause);
	}

	public String getMessage() {
		return message;
	}

}
