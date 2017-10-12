package com.epayments.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

/**
 * The type Error status.
 *
 * @author Kalidass Mahalingam
 */
public class ErrorStatus extends Status {
    private ErrorStatus.ErrorType error;
    private List<ErrorMessage> errorList;

    /**
     * Instantiates a new Error status.
     *
     * @param error the error
     */
    public ErrorStatus(ErrorStatus.ErrorType error) {
        this.type = Type.ERROR;
        this.error = error;
    }

    /**
     * Instantiates a new Error status.
     *
     * @param errorMessageList the error message list
     */
    public ErrorStatus(List<ErrorMessage> errorMessageList) {
        this.type = Type.ERROR;
        this.errorList = errorMessageList;
    }

    /**
     * Instantiates a new Error status.
     *
     * @param error      the error
     * @param errorCause the error cause
     */
    public ErrorStatus(ErrorStatus.ErrorType error, Object errorCause) {
        this.type = Type.ERROR;
        this.error = error;
    }

    protected Enum<ErrorStatus.ErrorType> getCode() {
        return this.error;
    }

    public String toString() {
        return "Error [type=" + this.type + ", error=" + this.error + ", errorMessageList=" + this.errorList + "]";
    }

    /**
     * Gets error.
     *
     * @return the error
     */
    public ErrorStatus.ErrorType getError() {
        return this.error;
    }

    /**
     * Gets error list.
     *
     * @return the error list
     */
    public List<ErrorMessage> getErrorList() {
        return this.errorList;
    }

    /**
     * Sets error list.
     *
     * @param errorList the error list
     */
    public void setErrorList(List<ErrorMessage> errorList) {
        this.errorList = errorList;
    }

    /**
     * The enum Error type.
     */
    @JsonFormat(
        shape = Shape.OBJECT
    )
    public static enum ErrorType {
        /**
         * Invalid input error type.
         */
        INVALID_INPUT(400, "INVALID_INPUT"),
        /**
         * Internal error error type.
         */
        INTERNAL_ERROR(500, "INTERNAL_ERROR");

        private final int code;
        private final String msg;

        private ErrorType(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        /**
         * Gets code.
         *
         * @return the code
         */
        public int getCode() {
            return this.code;
        }

        /**
         * Gets msg.
         *
         * @return the msg
         */
        public String getMsg() {
            return this.msg;
        }
    }
}
