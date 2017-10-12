package com.epayments.service.impl;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.epayments.model.TransferDetails;
import com.epayments.request.TransActionDetailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epayments.repository.TransferRepository;
import com.epayments.request.MoneyTransferRequest;
import com.epayments.response.MoneyTransferResponse;
import com.epayments.service.TransferService;


/**
 * The type Transfer service.
 *
 * @author Kalidass Mahalingam
 */
@Service("TransferService")
public class TransferServiceImpl implements TransferService {

    /**
     * The Transfer repository.
     */
    @Autowired
	TransferRepository transferRepository;



	@Override
	public CompletableFuture<MoneyTransferResponse> transferAmount(MoneyTransferRequest moneyTransferRequest) {
		return transferRepository.transferAmount(moneyTransferRequest);
	}

	@Override
	public CompletableFuture<List<TransferDetails>>getTransActionDetail(TransActionDetailRequest transActionDetailRequest) {
		return transferRepository.getTransActionDetail(transActionDetailRequest);
	}


}
