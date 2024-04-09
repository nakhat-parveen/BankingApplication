package com.paymentmicroservice.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymentmicroservice.dto.TransactionDto;
import com.paymentmicroservice.dto.TransactionResponseDto;
import com.paymentmicroservice.entity.Transaction;
import com.paymentmicroservice.feignclient.BankFeign;
import com.paymentmicroservice.repository.GpayRepository;

@Service
public class GpayServiceImpl implements GpayService {
	
	@Autowired
	BankFeign bankfeign;
	
	@Autowired
	GpayRepository gpayRepo;

	@Override
	public  TransactionResponseDto transactionViaPhoneNos(TransactionDto transferBalanceUsingPhone) {
		Transaction transaction= new Transaction();
		BeanUtils.copyProperties(transferBalanceUsingPhone, transaction);
		Transaction transactionDb= gpayRepo.save(transaction);
		TransactionResponseDto transactionResponseDto= new TransactionResponseDto();
		BeanUtils.copyProperties(transactionDb, transactionResponseDto);
		
		bankfeign.fundTransferThroughPhoneNos(transferBalanceUsingPhone);
		return transactionResponseDto;
	}

	@Override
	public List<Transaction> getLatestTransactions() {
		List<Transaction> transactions= gpayRepo.findAll();
		List<Transaction> transactionStream= transactions.stream().sorted(Comparator.comparing(Transaction::getDateTime)).limit(5).collect(Collectors.toList());
		return transactionStream;
	}

	@Override
	public List<Transaction> getAccountTransactions(String phoneNo) {
		
		return gpayRepo.findByFromPhoneNo(phoneNo);
	}

}
