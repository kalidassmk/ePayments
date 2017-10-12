package com.epayments.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.TimeZone;

/**
 * The type Session.
 */
@Document(collection = "session")
public class Session {

	@Id
	private ObjectId _id;

	private String correlationId;
	private String sessionId;
	private String customerId;
	private TimeZone timezone;
	private Long sessionCreationTime;

	public String getCorrelationId() {
		return correlationId;
	}

	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public TimeZone getTimezone() {
		return timezone;
	}

	public void setTimezone(TimeZone timezone) {
		this.timezone = timezone;
	}

	public Long getSessionCreationTime() {
		return sessionCreationTime;
	}

	public void setSessionCreationTime(Long sessionCreationTime) {
		this.sessionCreationTime = sessionCreationTime;
	}
}
