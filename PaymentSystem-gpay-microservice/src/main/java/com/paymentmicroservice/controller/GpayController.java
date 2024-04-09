package com.paymentmicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paymentmicroservice.dto.TransactionDto;
import com.paymentmicroservice.dto.TransactionResponseDto;
import com.paymentmicroservice.entity.Transaction;
import com.paymentmicroservice.service.GpayService;

@RestController
@RequestMapping("/gpay")
public class GpayController {
	@Autowired
	GpayService gpayService;
	
	@PostMapping("/transaction/via/gpay")
	public TransactionResponseDto fundTransferViaPhoneNos(@RequestBody TransactionDto transferBalanceUsingPhone) {
		
		return gpayService.transactionViaPhoneNos(transferBalanceUsingPhone);
	}
	
	@GetMapping("/latest-transactions")
	public List<Transaction> getTransactions(){
		return gpayService.getLatestTransactions();
	}
	
	@GetMapping("/transaction-details")
    public List<Transaction> getAccTransactions(@RequestParam String phoneNo){
	return gpayService.getAccountTransactions(phoneNo);
		
	}

}
