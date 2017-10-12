package com.epayments.request;

import javax.validation.constraints.NotNull;

/**
 * Created by kamahalingam on 10/12/2017.
 */
public class UserSessionRequest {

    @NotNull
    private String customerId;

    @NotNull
    private String clientId;

    @NotNull
    private String clientSecret;

    public UserSessionRequest() {
    }

    public UserSessionRequest(String customerId, String clientId, String clientSecret) {
        this.customerId = customerId;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }
}
