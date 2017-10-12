package com.epayments.repository.impl;

import com.epayments.model.Account;
import com.epayments.model.AccountResponse;
import com.epayments.model.customer.Customer;
import com.epayments.model.customer.CustomerInfo;
import com.epayments.repository.AccountRepository;
import com.epayments.request.AccountDetailRequest;
import com.epayments.request.CreateAccountRequest;
import com.epayments.response.CreateAccountResponse;
import com.epayments.util.KeyGeneration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static com.epayments.response.EPaymentState.ACCOUNT_CREATED;

/**
 * Created by kamahalingam on 10/12/2017.
 */
@Repository("accountRepository")
public class AccountRepositoryImpl implements AccountRepository {

    /**
     * The Mongo template.
     */
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public CompletableFuture<CreateAccountResponse> openAccount(CreateAccountRequest createAccountRequest) {
        return CompletableFuture.supplyAsync(() -> {
            Account account = new Account();
            account.setCustomerId(createAccountRequest.getCustomerId());
            account.setInitialBalance(createAccountRequest.getInitialBalance());
            account.setAccountNo(KeyGeneration.getaccountNo());
            account.setDescription(createAccountRequest.getDescription());
            Customer customer = new Customer();
            customer.setCustomerId(createAccountRequest.getCustomerId());
            customer.setCustomerInfo(createAccountRequest.getCustomerInfo());
            account.setCustomer(customer);
            account.setStatus("Active");
            account.setCurrencyCode("EURO");
            mongoTemplate.insert(account);
            return new CreateAccountResponse(account.getAccountNo(), ACCOUNT_CREATED);
        });
    }

    @Override
    public CompletableFuture<List<AccountResponse>> getAccountDetail(AccountDetailRequest accountDetailRequest) {
        return CompletableFuture.supplyAsync(() -> {
            Query query = new Query();
            Criteria criteria = Criteria.where("customerId").is(accountDetailRequest.getCustomerId()).and("status").is("Active");
            if (accountDetailRequest.getAccountNo() != null) {
                criteria.and("accountNo").is(accountDetailRequest.getAccountNo());
            }
            query.addCriteria(criteria);
            List<Account> accountList = mongoTemplate.find(query, Account.class);
            return accountList.stream().map(account -> {
                AccountResponse accountResponse = new AccountResponse();
                Customer cust = account.getCustomer();
                accountResponse.setAccountNo(account.getAccountNo());
                accountResponse.setCustomerId(account.getCustomerId());
                accountResponse.setBalance(account.getInitialBalance());
                accountResponse.setCurrencyCode(account.getCurrencyCode());
                if (cust != null && cust.getCustomerInfo() != null) {
                    CustomerInfo info = cust.getCustomerInfo();
                    accountResponse.setDateOfBirth(info.getDateOfBirth());
                    accountResponse.setPhoneNumber(info.getPhoneNumber());
                    accountResponse.setFirstName(info.getName() != null ? info.getName().getFirstName() : "");
                    accountResponse.setLastName(info.getName() != null ? info.getName().getLastName() : "");
                }
                return accountResponse;
            }).collect(Collectors.toList());

        });
    }
}
