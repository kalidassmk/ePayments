package com.epayments.session;

import java.util.concurrent.CompletableFuture;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;

import com.epayments.model.Session;

/**
 * The interface Session service.
 */
public interface SessionService {
    /**
     * Gets session.
     *
     * @param headers the headers
     *
     * @return the session
     */
    public CompletableFuture<Session> getSession(HttpHeaders headers);
}
