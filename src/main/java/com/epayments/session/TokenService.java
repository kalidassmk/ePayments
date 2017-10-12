package com.epayments.session;

import com.epayments.model.Session;
import com.epayments.model.Token;

/**
 * The interface Token service.
 */
public interface TokenService {
    /**
     * Verify token session.
     *
     * @param sessionId the session id
     *
     * @return the session
     */
    Session verifyToken(String sessionId);
}
