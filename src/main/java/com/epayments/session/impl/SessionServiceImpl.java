package com.epayments.session.impl;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.epayments.model.Session;
import com.epayments.session.SessionService;
import com.epayments.session.TokenService;

/**
 * The type Session service.
 */
@Service("sessionService")
public class SessionServiceImpl implements SessionService {


	private static final String AUTH_HEADER_NAME = "access-token";
	private static final long DAY = 1000 * 60 * 5;

	public CompletableFuture<Session> getSession(HttpHeaders headers) {
		return CompletableFuture.supplyAsync(() -> {
//			String sessionId = headers..(AUTH_HEADER_NAME);
			/*Session session = tokenService.verifyToken(sessionId);
			if ((System.currentTimeMillis() - session.getSessionCreationTime()) < DAY) {
				return session;
			}*/
			return new Session();
		});

	}
}
