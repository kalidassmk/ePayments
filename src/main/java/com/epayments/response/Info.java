package com.epayments.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

/**
 * The type Info.
 *
 * @author Kalidass Mahalingam
 */
public class Info extends Status {
    private Info.InfoType info;

    /**
     * Instantiates a new Info.
     *
     * @param info the info
     */
    public Info(Info.InfoType info) {
        this.type = Type.INFO;
        this.info = info;
    }

    protected Enum<Info.InfoType> getCode() {
        return this.info;
    }

    public String toString() {
        return "Info [type=" + this.type + ", info=" + this.info + "]";
    }

    /**
     * Gets info.
     *
     * @return the info
     */
    public Info.InfoType getInfo() {
        return this.info;
    }

    /**
     * The enum Info type.
     */
    @JsonFormat(
        shape = Shape.OBJECT
    )
    public static enum InfoType {
        /**
         * Info ok info type.
         */
        INFO_OK(1000, "OK");

        private final int code;
        private final String msg;

        private InfoType(int code, String msg) {
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
