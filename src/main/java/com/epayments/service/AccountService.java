package com.epayments.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import com.epayments.model.Account;
import com.epayments.model.AccountResponse;
import com.epayments.request.CreateAccountRequest;
import com.epayments.request.AccountDetailRequest;
import com.epayments.response.CreateAccountResponse;

/**
 * The interface Account service.
 */
public interface AccountService {

    /**
     * Open account completion stage.
     *
     * @param createAccountRequest the create account request
     *
     * @return the completion stage
     */
    CompletableFuture<CreateAccountResponse> openAccount(CreateAccountRequest createAccountRequest);

    /**
     * Gets account detail.
     *
     * @param accountDetailRequest the account detail request
     *
     * @return the account detail
     */
    CompletableFuture<List<AccountResponse>> getAccountDetail(AccountDetailRequest accountDetailRequest);

}
