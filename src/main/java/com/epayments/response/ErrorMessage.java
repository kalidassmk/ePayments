package com.epayments.response;

/**
 * The type Error message.
 *
 * @author Kalidass Mahalingam
 */
public class ErrorMessage {
    private String code;
    private String fieldName;
    private String message;

    /**
     * Instantiates a new Error message.
     *
     * @param code      the code
     * @param fieldName the field name
     * @param message   the message
     */
    public ErrorMessage(String code, String fieldName, String message) {
        this.code = code;
        this.fieldName = fieldName;
        this.message = message;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public String getCode() {
        return this.code;
    }

    /**
     * Sets code.
     *
     * @param code the code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets field name.
     *
     * @return the field name
     */
    public String getFieldName() {
        return this.fieldName;
    }

    /**
     * Sets field name.
     *
     * @param fieldName the field name
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String toString() {
        return "ErrorMessage [code=" + this.code + ", invalidField=" + this.fieldName + ", message=" + this.message + "]";
    }
}