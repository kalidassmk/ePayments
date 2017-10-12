package com.epayments.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.epayments.model.TransferDetails;
import com.epayments.request.MoneyTransferRequest;
import com.epayments.request.TransActionDetailRequest;
import com.epayments.response.MoneyTransferResponse;

/**
 * The interface Transfer service.
 *
 * @author Kalidass Mahalingam
 */
public interface TransferService {
    /**
     * Transfer amount completable future.
     *
     * @param moneyTransferRequest the money transfer request
     *
     * @return the completable future
     */
    CompletableFuture<MoneyTransferResponse> transferAmount(MoneyTransferRequest moneyTransferRequest);

    /**
     * Gets trans action detail.
     *
     * @param transActionDetailRequest the trans action detail request
     *
     * @return the trans action detail
     */
    CompletableFuture<List<TransferDetails>> getTransActionDetail(TransActionDetailRequest transActionDetailRequest);

}
