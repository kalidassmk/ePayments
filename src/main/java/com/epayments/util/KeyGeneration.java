package com.epayments.util;

import java.security.SecureRandom;
import java.util.Random;

/**
 * The type Account id generation.
 */
public class KeyGeneration {

    /**
     * Gets account id.
     *
     * @return the account id
     */
    public static synchronized String getaccountNo() {
        return  (""+getRand()).replace("-", "");
    }

    /**
     * Gets transation id.
     *
     * @return the transation id
     */
    public static synchronized String getTransationId() {
        return  (""+getRand()).replace("-", "");
    }


    private static long getRand() {
        Random rand = new Random();
        return rand.nextLong();
    }

}

