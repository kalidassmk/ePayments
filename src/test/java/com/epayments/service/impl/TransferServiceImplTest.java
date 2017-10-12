package com.epayments.service.impl;

import com.epayments.model.TransferDetails;
import com.epayments.repository.TransferRepository;
import com.epayments.request.MoneyTransferRequest;
import com.epayments.request.TransActionDetailRequest;
import com.epayments.response.MoneyTransferResponse;
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
public class TransferServiceImplTest {
    @Mock
    TransferRepository transferRepository;
    @InjectMocks
    TransferServiceImpl transferServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testTransferAmount() throws Exception {
        CompletableFuture<MoneyTransferResponse> result = transferServiceImpl.transferAmount(new MoneyTransferRequest("fromaccountNo", "toaccountNo", new BigDecimal(0), "description"));
        Assert.assertEquals(null, result);
    }

    @Test
    public void testGetTransActionDetail() throws Exception {
        CompletableFuture<List<TransferDetails>> result = transferServiceImpl.getTransActionDetail(new TransActionDetailRequest("customerId", "accountNo", "transactionId"));
        Assert.assertEquals(null, result);
    }
}

