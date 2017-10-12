package com.epayments.repository;

import com.epayments.model.AccountResponse;
import com.epayments.request.CreateAccountRequest;
import com.epayments.request.AccountDetailRequest;
import com.epayments.response.CreateAccountResponse;

import com.epayments.model.Account;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * The interface Account repository.
 */
public interface AccountRepository  {

    /**
     * Open account completable future.
     *
     * @param createAccountRequest the create account request
     *
     * @return the completable future
     */
    CompletableFuture<CreateAccountResponse>  openAccount(CreateAccountRequest createAccountRequest);

    /**
     * Gets account detail.
     *
     * @param accountDetailRequest the account detail request
     *
     * @return the account detail
     */
    CompletableFuture<List<AccountResponse>>  getAccountDetail(AccountDetailRequest accountDetailRequest);


}
