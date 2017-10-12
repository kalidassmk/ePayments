package com.epayments.session.impl;

import java.util.concurrent.CompletableFuture;

import com.epayments.repository.TokenRepository;
import com.epayments.request.UserSessionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.epayments.model.Session;
import com.epayments.session.SessionService;

/**
 * The type Session service.
 */
@Service("sessionService")
public class SessionServiceImpl implements SessionService {

	@Autowired
	TokenRepository tokenRepository;

	public static final String AUTH_HEADER_NAME = "X-Auth-Token";
	private static final long DAY = 1000 * 60 * 5;

	public CompletableFuture<Session> getSession(HttpHeaders headers) {
		String sessionId = headers.getFirst(AUTH_HEADER_NAME);
		return tokenRepository.verifyToken(sessionId).thenApply(session -> {
			if ((System.currentTimeMillis() - session.getSessionCreationTime()) < DAY) {
				return session;
			}
			return new Session();
		});
	}

	@Override
	public CompletableFuture<Session> createUserSession(UserSessionRequest userSessionRequest) {
		return tokenRepository.createUserSession(userSessionRequest);
	}


}
