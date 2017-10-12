package com.epayments.controller;

import com.epayments.model.AccountResponse;
import com.epayments.model.Session;
import com.epayments.model.TransferDetails;
import com.epayments.request.AccountDetailRequest;
import com.epayments.request.CreateAccountRequest;
import com.epayments.request.MoneyTransferRequest;
import com.epayments.request.TransActionDetailRequest;
import com.epayments.response.CreateAccountResponse;
import com.epayments.response.EPaymentState;
import com.epayments.response.MoneyTransferResponse;
import com.epayments.service.AccountService;
import com.epayments.service.TransferService;
import com.epayments.session.SessionService;
import com.epayments.util.KeyGeneration;
import com.epayments.util.ServiceUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.slf4j.Logger;
import org.springframework.http.HttpHeaders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.epayments.response.EPaymentState.ACCOUNT_CREATED;
import static com.epayments.response.EPaymentState.TRANSACTION_COMPLETED;
import static java.util.concurrent.CompletableFuture.supplyAsync;
import static jdk.nashorn.internal.objects.NativeDate.setDate;

/**
 * Created by kamahalingam on 10/12/2017.
 */
public class EPaymentControllerTest {

    @Mock
    AccountService accountService;
    @Mock
    TransferService transferService;
    @Mock
    SessionService sessionService;
    @Mock
    Logger logger;
    @InjectMocks
    EPaymentController ePaymentController;

    @Mock
    HttpHeaders header;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Session session = new Session();
        CompletableFuture<Session> sessionFuture = supplyAsync(() -> session);
        PowerMockito.when(sessionService.getSession(Mockito.any(HttpHeaders.class))).thenReturn(sessionFuture);
    }

    @Test
    public void testOpenAccount() throws Exception {
        CompletableFuture<CreateAccountResponse> future = supplyAsync(() -> new CreateAccountResponse() {{
            setAccountNo("1");
            setStatus(ACCOUNT_CREATED);
        }});
        PowerMockito.when(accountService.openAccount(Mockito.any())).thenReturn(future);
        CompletableFuture<JsonNode> result = ePaymentController.openAccount(new CreateAccountRequest("customerId", "title", "description", new BigDecimal(0)), new HttpHeaders());
        JsonNode resp = result.get();
        CreateAccountResponse createAccountResponse = ServiceUtil.fromJson(resp.get("payLoad"), CreateAccountResponse.class);
        Assert.assertEquals("1", createAccountResponse.getAccountNo());
        Assert.assertEquals(ACCOUNT_CREATED, createAccountResponse.getStatus());

    }

    @Test
    public void testTransferAmount() throws Exception {
        String transActionId = KeyGeneration.getTransationId();
        CompletableFuture<MoneyTransferResponse> future = supplyAsync(() -> new MoneyTransferResponse() {{
            setTransactionId(transActionId);
            setEPaymentState(TRANSACTION_COMPLETED);
        }});
        PowerMockito.when(transferService.transferAmount(Mockito.any())).thenReturn(future);
        CompletableFuture<JsonNode> result = ePaymentController.transferAmount(new MoneyTransferRequest("fromaccountNo", "toaccountNo", new BigDecimal(0), "description"), new HttpHeaders());
        JsonNode resp = result.get();
        MoneyTransferResponse moneyTransferResponse = ServiceUtil.fromJson(resp.get("payLoad"), MoneyTransferResponse.class);
        Assert.assertEquals(transActionId, moneyTransferResponse.getTransactionId());
        Assert.assertEquals(TRANSACTION_COMPLETED, moneyTransferResponse.getEPaymentState());
    }



    @Test
    public void testGetTransActionDetail() throws Exception {
        List<TransferDetails> list = new ArrayList<>();
        String transActionId = KeyGeneration.getTransationId();
        CompletableFuture<List<TransferDetails>> future = supplyAsync(() -> new ArrayList<TransferDetails>() {{
            add(new TransferDetails() {{
                setAmount(new BigDecimal("100"));
                setDate(new Date());
                setDescription("desc");
                setEPaymentState(TRANSACTION_COMPLETED);
                setFromAccountNo("1");
                setToAccountNo("2");
                setTransactionId(transActionId);
            }});
        }});

        PowerMockito.when(transferService.getTransActionDetail(Mockito.any())).thenReturn(future);
        CompletableFuture<JsonNode> result = ePaymentController.getTransActionDetail(new TransActionDetailRequest("customerId", "accountNo", "transactionId"), new HttpHeaders());
        JsonNode resp = result.get();
        List<TransferDetails> transferDetailsList = ServiceUtil.mapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false).readValue(resp.get("payLoad").toString(), new TypeReference<List<TransferDetails>>() {
        });

        TransferDetails transferDetails =transferDetailsList.get(0);
        Assert.assertEquals("1", transferDetails.getFromAccountNo());
        Assert.assertEquals("2", transferDetails.getToAccountNo());
    }

    @Test
    public void testGetAccountDetail() throws Exception {
        CompletableFuture<List<AccountResponse>> future = supplyAsync(() -> new ArrayList<AccountResponse>() {{
            add(new AccountResponse() {{
                setAccountNo("1");
                setDate(new Date());
                setPhoneNumber("12345678");
                setLastName("Mahalingam");
                setFirstName("Kalidass");
                setDateOfBirth("12/05/1986");
                setBalance(new BigDecimal("100"));
                setCustomerId("cust1");
            }});
        }});
        PowerMockito.when(accountService.getAccountDetail(Mockito.any(AccountDetailRequest.class))).thenReturn(future);
        ePaymentController.getAccountDetail(new AccountDetailRequest("customerId1", "1"), new HttpHeaders());

    }
}

