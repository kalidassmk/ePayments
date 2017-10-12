package com.epayments.repository.impl;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.epayments.model.TransferDetails;
import com.epayments.model.Account;
import com.epayments.request.TransActionDetailRequest;
import com.epayments.response.EPaymentState;
import com.epayments.util.KeyGeneration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.epayments.repository.TransferRepository;
import com.epayments.request.MoneyTransferRequest;
import com.epayments.response.MoneyTransferResponse;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.in;

/**
 * The type Transfer repository.
 *
 * @author Kalidass Mahalingam
 */
@Repository("TransferRepository")
public class TransferRepositoryImpl implements TransferRepository {

    /**
     * The Mongo template.
     */
    @Autowired
    MongoTemplate mongoTemplate;


    @Override
    public CompletableFuture<MoneyTransferResponse> transferAmount(MoneyTransferRequest moneyTransferRequest) {
        return CompletableFuture.supplyAsync(() -> {

            List<Account> accountList;
            Account toAccount = null;
            Account fromAccount = null;
            Account revertToAccount = null;
            Account revertFromAccount = null;
            EPaymentState EPaymentState = null;

            String transactionId = KeyGeneration.getTransationId();
            MoneyTransferResponse moneyTransferResponse = new MoneyTransferResponse();
            moneyTransferResponse.setTransactionId(transactionId);
            try {
                Query query = new Query();
                List<String> accountFilter = new ArrayList<>();

                accountFilter.add(moneyTransferRequest.getToaccountNo());
                accountFilter.add(moneyTransferRequest.getFromaccountNo());
                query.addCriteria(Criteria.where("accountNo").in(accountFilter).and("status").is("Active"));

                accountList = mongoTemplate.find(query, Account.class);

                for (Account account : accountList) {
                    if (account.getAccountNo().equals(moneyTransferRequest.getFromaccountNo())) {
                        fromAccount = account;
                        revertFromAccount = account;
                    } else if (account.getAccountNo().equals(moneyTransferRequest.getToaccountNo())) {
                        toAccount = account;
                        revertToAccount = account;
                    }
                }

                if (fromAccount != null && toAccount != null) {
                    if (moneyTransferRequest.getAmount().compareTo(fromAccount.getInitialBalance()) == 1) {
                        EPaymentState = EPaymentState.FAILED_DUE_TO_INSUFFICIENT_FUNDS;
                    } else {
                        BigDecimal fromAmount = fromAccount.getInitialBalance().subtract(moneyTransferRequest.getAmount(), MathContext.DECIMAL128);
                        fromAccount.setInitialBalance(fromAmount);

                        BigDecimal amount = toAccount.getInitialBalance().add(moneyTransferRequest.getAmount());
                        toAccount.setInitialBalance(amount);
                        update(fromAccount, toAccount);
                        EPaymentState = EPaymentState.TRANSACTION_COMPLETED;
                    }

                } else {
                    if (fromAccount == null) {
                        EPaymentState = EPaymentState.SOURCE_ACCOUNT_NOT_ACTIVE;
                    } else {
                        EPaymentState = EPaymentState.DESTINATION_ACCOUNT_NOT_ACTIVE;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                update(revertFromAccount, revertToAccount);
                EPaymentState = EPaymentState.FAILED;
            }
            moneyTransferResponse.setEPaymentState(EPaymentState);
            updateTransActionDetail(transactionId, moneyTransferRequest.getFromaccountNo(), moneyTransferRequest.getToaccountNo(),
                    moneyTransferRequest.getAmount(), EPaymentState, moneyTransferRequest.getSourceCurrencyCode(), moneyTransferRequest.getDestinationCurrencyCode());
            return moneyTransferResponse;

        });

    }

    @Override
    public CompletableFuture<List<TransferDetails>> getTransActionDetail(TransActionDetailRequest transActionDetailRequest) {
        return CompletableFuture.supplyAsync(() -> {
            Query query = new Query();
            Criteria criteria = Criteria.where("fromAccountNo").is( transActionDetailRequest.getAccountNo());
            Criteria orCriteria = new Criteria("toAccountNo").is( transActionDetailRequest.getAccountNo());
            criteria.norOperator(orCriteria);
            if (transActionDetailRequest.getTransactionId() != null) {
                criteria.and("transactionId").is(transActionDetailRequest.getTransactionId());
            }
            query.addCriteria(criteria);
            List<TransferDetails> accountList = mongoTemplate.find(query, TransferDetails.class);
            return accountList;
        });
    }

    private void update(Account fromAccount, Account toAccount) {
        mongoTemplate.save(fromAccount);
        mongoTemplate.save(toAccount);
    }

    private void updateTransActionDetail(String transactionId, String fromAccountNo, String toAccountNo, BigDecimal amount,
                     EPaymentState EPaymentState, String sourceCurrencyCode, String destinationCurrencyCode) {
        TransferDetails transferDetails = new TransferDetails();
        transferDetails.setAmount(amount);
        transferDetails.setDate(new Date());
        transferDetails.setFromAccountNo(fromAccountNo);
        transferDetails.setToAccountNo(toAccountNo);
        transferDetails.setEPaymentState(EPaymentState);
        transferDetails.setTransactionId(transactionId);
        transferDetails.setSourceCurrencyCode(sourceCurrencyCode);
        transferDetails.setDestinationCurrencyCode(destinationCurrencyCode);
        mongoTemplate.insert(transferDetails);
    }

}
