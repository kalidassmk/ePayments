package com.epayments.service.impl;

import com.epayments.model.AccountResponse;
import com.epayments.repository.AccountRepository;
import com.epayments.request.AccountDetailRequest;
import com.epayments.request.CreateAccountRequest;
import com.epayments.response.CreateAccountResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.mockito.Mockito.*;

/**
 * Created by kamahalingam on 10/12/2017.
 */
public class AccountServiceImplTest {
    @Mock
    AccountRepository accountRepository;
    @InjectMocks
    AccountServiceImpl accountServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testOpenAccount() throws Exception {
        CompletableFuture<CreateAccountResponse> result = accountServiceImpl.openAccount(new CreateAccountRequest("customerId", "title", "description", new BigDecimal(0)));
        Assert.assertEquals(null, result);
    }

    @Test
    public void testGetAccountDetail() throws Exception {
        CompletableFuture<List<AccountResponse>> result = accountServiceImpl.getAccountDetail(new AccountDetailRequest("customerId", "accountNo"));
        Assert.assertEquals(null, result);
    }
}

