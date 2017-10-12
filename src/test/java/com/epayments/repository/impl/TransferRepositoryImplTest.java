package com.epayments.repository.impl;

import com.epayments.model.TransferDetails;
import com.epayments.request.MoneyTransferRequest;
import com.epayments.request.TransActionDetailRequest;
import com.epayments.response.MoneyTransferResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.mockito.Mockito.*;

/**
 * Created by kamahalingam on 10/12/2017.
 */

@RunWith(PowerMockRunner.class)
public class TransferRepositoryImplTest {
    @Mock
    MongoTemplate mongoTemplate;
    @InjectMocks
    TransferRepositoryImpl transferRepositoryImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testTransferAmount() throws Exception {
        CompletableFuture<MoneyTransferResponse> result = transferRepositoryImpl.transferAmount(new MoneyTransferRequest("fromaccountNo", "toaccountNo", new BigDecimal(0), "description","",""));
    }

    @Test
    public void testGetTransActionDetail() throws Exception {
        CompletableFuture<List<TransferDetails>> result = transferRepositoryImpl.getTransActionDetail(new TransActionDetailRequest("customerId", "accountNo", "transactionId"));
    }
}

