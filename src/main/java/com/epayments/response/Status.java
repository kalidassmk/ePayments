package com.epayments.response;

/**
 * The type Status.
 *
 * @author Kalidass Mahalingam
 */
public abstract class Status {
    /**
     * The Type.
     */
    protected Status.Type type;
    /**
     * The Cause.
     */
    protected Object cause;

    /**
     * Instantiates a new Status.
     */
    public Status() {
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public Status.Type getType() {
        return this.type;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    @SuppressWarnings("rawtypes")
	protected abstract Enum getCode();

    /**
     * Gets cause.
     *
     * @return the cause
     */
    public Object getCause() {
        return this.cause;
    }

    /**
     * The enum Type.
     */
    public static enum Type {
        /**
         * Info type.
         */
        INFO,
        /**
         * Warning type.
         */
        WARNING,
        /**
         * Error type.
         */
        ERROR,
        /**
         * Critical type.
         */
        CRITICAL;

        private Type() {
        }
    }
}