package com.epayments.model;

import java.util.TimeZone;

/**
 * The type Session.
 */
public class Session {
	
	private String correlationId;
	private String sessionId;
	private String userName;
	private String accountNo;
	private TimeZone timezone;
	private String language;
	private String currencyCode;
	private String firstName;
	private String lastName;
	private Long sessionCreationTime;

    /**
     * Gets correlation id.
     *
     * @return the correlation id
     */
    public String getCorrelationId() {
		return correlationId;
	}

    /**
     * Sets correlation id.
     *
     * @param correlationId the correlation id
     */
    public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}

    /**
     * Gets session id.
     *
     * @return the session id
     */
    public String getSessionId() {
		return sessionId;
	}

    /**
     * Sets session id.
     *
     * @param sessionId the session id
     */
    public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
		return userName;
	}

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
		this.userName = userName;
	}

    /**
     * Gets account no.
     *
     * @return the account no
     */
    public String getAccountNo() {
		return accountNo;
	}

    /**
     * Sets account no.
     *
     * @param accountNo the account no
     */
    public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

    /**
     * Gets timezone.
     *
     * @return the timezone
     */
    public TimeZone getTimezone() {
		return timezone;
	}

    /**
     * Sets timezone.
     *
     * @param timezone the timezone
     */
    public void setTimezone(TimeZone timezone) {
		this.timezone = timezone;
	}

    /**
     * Gets language.
     *
     * @return the language
     */
    public String getLanguage() {
		return language;
	}

    /**
     * Sets language.
     *
     * @param language the language
     */
    public void setLanguage(String language) {
		this.language = language;
	}

    /**
     * Gets currency code.
     *
     * @return the currency code
     */
    public String getCurrencyCode() {
		return currencyCode;
	}

    /**
     * Sets currency code.
     *
     * @param currencyCode the currency code
     */
    public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
		return firstName;
	}

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
		return lastName;
	}

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
		this.lastName = lastName;
	}

    /**
     * Gets session creation time.
     *
     * @return the session creation time
     */
    public Long getSessionCreationTime() {
		return sessionCreationTime;
	}

    /**
     * Sets session creation time.
     *
     * @param sessionCreationTime the session creation time
     */
    public void setSessionCreationTime(Long sessionCreationTime) {
		this.sessionCreationTime = sessionCreationTime;
	}

}
