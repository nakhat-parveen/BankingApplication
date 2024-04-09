package com.paymentmicroservice.service;

import java.util.List;

import com.paymentmicroservice.dto.TransactionDto;
import com.paymentmicroservice.dto.TransactionResponseDto;
import com.paymentmicroservice.entity.Transaction;

public interface GpayService {
	
	public TransactionResponseDto transactionViaPhoneNos(TransactionDto transferBalanceUsingPhone);

	public List<Transaction> getLatestTransactions();

	public List<Transaction> getAccountTransactions(String phoneNo);

}
