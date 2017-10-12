package com.epayments.repository.impl;

import com.epayments.model.Session;
import com.epayments.model.TransferDetails;
import com.epayments.repository.TokenRepository;
import com.epayments.request.UserSessionRequest;
import com.epayments.util.KeyGeneration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.CompletableFuture;

/**
 * Created by kamahalingam on 10/12/2017.
 */
@Repository("tokenRepository")
public class TokenRepositoryImpl implements TokenRepository {
    /**
     * Verify token session.
     *
     * @param sessionId the session id
     * @return the session
     */
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public CompletableFuture<Session> verifyToken(String sessionId) {
        return CompletableFuture.supplyAsync(() -> {
            Query query = new Query();
            Criteria criteria = Criteria.where("sessionId").is(sessionId);
            query.addCriteria(criteria);
            Session session = mongoTemplate.findOne(query, Session.class);
            return session;
        });
    }

    @Override
    public CompletableFuture<Session> createUserSession(UserSessionRequest userSessionRequest) {
        return CompletableFuture.supplyAsync(() -> {
            Session session = new Session();
            session.setCustomerId(userSessionRequest.getCustomerId());
            session.setTimezone(TimeZone.getTimeZone("GMT"));
            session.setSessionCreationTime(new Date().getTime());
            session.setCorrelationId("" + System.currentTimeMillis());
            session.setSessionId("" + System.currentTimeMillis() + KeyGeneration.getTransationId());
            mongoTemplate.save(session);
            return session;
        });
    }
}
