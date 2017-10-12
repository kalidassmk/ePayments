package com.epayments.session.impl;

import com.epayments.model.Session;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpHeaders;

import java.util.concurrent.CompletableFuture;

/**
 * Created by kamahalingam on 10/12/2017.
 */
public class SessionServiceImplTest {
    SessionServiceImpl sessionServiceImpl = new SessionServiceImpl();

    @Test
    public void testGetSession() throws Exception {
        CompletableFuture<Session> result = sessionServiceImpl.getSession(new HttpHeaders());
        Assert.assertNotNull(result);
    }
}

