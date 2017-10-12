package com.epayments.controller;

import java.util.concurrent.CompletableFuture;

import com.epayments.request.AccountDetailRequest;
import com.epayments.request.TransActionDetailRequest;
import com.epayments.request.UserSessionRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epayments.request.CreateAccountRequest;
import com.epayments.request.MoneyTransferRequest;
import com.epayments.response.ResponseToClient;
import com.epayments.service.AccountService;
import com.epayments.service.TransferService;
import com.epayments.session.SessionService;
import com.fasterxml.jackson.databind.JsonNode;

import static com.epayments.session.impl.SessionServiceImpl.AUTH_HEADER_NAME;

/**
 * The type E payment controller.
 *
 * @author Kalidass Mahalingam
 */
@RestController
public class EPaymentController {

	/**
	 * The Account service.
	 */
	@Autowired
	AccountService accountService;

	@Autowired
	private TransferService transferService;

	@Autowired
	private SessionService sessionService;
	
	private final Logger logger = LoggerFactory.getLogger(EPaymentController.class);

	/**
	 * Open account completable future.
	 *
	 * @param createAccountRequest the create account request
	 * @param headers              the headers
	 *
	 * @return the completable future
	 */
	@Async
    @RequestMapping(value = "/openAccount", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CompletableFuture<JsonNode> openAccount(@RequestBody CreateAccountRequest createAccountRequest, @RequestHeader HttpHeaders headers) {
		logger.info("open the account" + headers.get(AUTH_HEADER_NAME));
		return  sessionService.getSession(headers).thenCompose(session -> {
			return accountService.openAccount(createAccountRequest).thenApply(resp -> ResponseToClient.objectToClient(resp));
		});
	}

	/**
	 * Transfer amount completable future.
	 *
	 * @param moneyTransferRequest the money transfer request
	 * @param headers              the headers
	 *
	 * @return the completable future
	 */
	@Async
    @RequestMapping(value = "/transferAmount", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CompletableFuture<JsonNode> transferAmount(@RequestBody MoneyTransferRequest moneyTransferRequest, @RequestHeader HttpHeaders headers) {
		logger.info("transfer the amount" + headers.get(AUTH_HEADER_NAME));
		return  sessionService.getSession(headers).thenCompose(session -> {
			return transferService.transferAmount(moneyTransferRequest).thenApply(resp -> ResponseToClient.objectToClient(resp));
		});
	}


	/**
	 * Gets account detail.
	 *
	 * @param accountDetailRequest the account detail request
	 * @param headers              the headers
	 *
	 * @return the account detail
	 */
	@Async
	@RequestMapping(value = "/getAccountDetail", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CompletableFuture<JsonNode> getAccountDetail(@RequestBody AccountDetailRequest accountDetailRequest, @RequestHeader HttpHeaders headers) {
		logger.info("get te the account Detail" + headers.get(AUTH_HEADER_NAME));
		return  sessionService.getSession(headers).thenCompose(session -> {
			return accountService.getAccountDetail(accountDetailRequest).thenApply(resp -> ResponseToClient.objectToClient(resp));
		});
	}

	/**
	 * Gets trans action detail.
	 *
	 * @param transActionDetailRequest the trans action detail request
	 * @param headers                  the headers
	 *
	 * @return the trans action detail
	 */
	@Async
	@RequestMapping(value = "/getTransActionDetail", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CompletableFuture<JsonNode> getTransActionDetail(@RequestBody TransActionDetailRequest transActionDetailRequest, @RequestHeader HttpHeaders headers) {
		logger.info("get te the transaction Detail" + headers.get(AUTH_HEADER_NAME));
		return  sessionService.getSession(headers).thenCompose(session -> {
			return transferService.getTransActionDetail(transActionDetailRequest).thenApply(resp -> ResponseToClient.objectToClient(resp));
		});
	}

	/**
	 * Gets trans action detail.
	 *
	 * @return the trans action detail
	 */
	@Async
	@RequestMapping(value = "/createUserSession", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CompletableFuture<JsonNode> createUserSession(@RequestBody UserSessionRequest userSessionRequest) {
		return sessionService.createUserSession(userSessionRequest).thenApply(session
				-> ResponseToClient.objectToClient(session));
	}

}
