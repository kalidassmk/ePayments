package com.epayments.service.impl;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import com.epayments.model.AccountResponse;
import com.epayments.request.AccountDetailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epayments.model.Account;
import com.epayments.repository.AccountRepository;
import com.epayments.request.CreateAccountRequest;
import com.epayments.response.CreateAccountResponse;
import com.epayments.service.AccountService;

/**
 * The type Account service.
 */
@Service("AccountService")
public class AccountServiceImpl implements AccountService {

	/**
	 * The Account repository.
	 */
	@Autowired
	AccountRepository accountRepository;

	@Override
	public CompletableFuture<CreateAccountResponse> openAccount(CreateAccountRequest createAccountRequest) {
		return accountRepository.openAccount(createAccountRequest);
	}

	@Override
	public CompletableFuture<List<AccountResponse>> getAccountDetail(AccountDetailRequest accountDetailRequest) {
		return accountRepository.getAccountDetail(accountDetailRequest);
	}

}
