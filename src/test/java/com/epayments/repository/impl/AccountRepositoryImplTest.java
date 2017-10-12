package com.epayments.repository.impl;

import com.epayments.model.AccountResponse;
import com.epayments.request.AccountDetailRequest;
import com.epayments.request.CreateAccountRequest;
import com.epayments.response.CreateAccountResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.mockito.Mockito.*;

/**
 * Created by kamahalingam on 10/12/2017.
 */
public class AccountRepositoryImplTest {
    @Mock
    MongoTemplate mongoTemplate;
    @InjectMocks
    AccountRepositoryImpl accountRepositoryImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testOpenAccount() throws Exception {
        PowerMockito.doNothing().when(mongoTemplate).insert(Mockito.any());
        accountRepositoryImpl.openAccount(new CreateAccountRequest("customerId", "title", "description", new BigDecimal(0)));
    }

    @Test
    public void testGetAccountDetail() throws Exception {
       accountRepositoryImpl.getAccountDetail(new AccountDetailRequest("customerId", "accountNo"));
    }
}

