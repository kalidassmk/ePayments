package com.epayments.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by kamahalingam on 10/12/2017.
 */
public class KeyGenerationTest {

    @Test
    public void testGetaccountNo() throws Exception {
        String result = KeyGeneration.getaccountNo();
        String result2 = KeyGeneration.getTransationId();
        Assert.assertNotNull(result2);
        Assert.assertNotNull(result);
    }
}

