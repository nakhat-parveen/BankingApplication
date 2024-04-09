package com.bankapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dtos.accountdtos.AccountRequestDto;
import com.bankapp.entities.Account;
import com.bankapp.entities.Customer;
import com.bankapp.entities.Transaction;
import com.bankapp.pojos.TransferBalanceRequest;
import com.bankapp.service.AccountService;
import com.bankapp.transactiondto.TransactionResponseDto;
import com.bankapp.transactiondto.TransferBalanceUsingPhoneDto;

@RestController
@RequestMapping("/transaction")
public class AccountController {
	@Autowired
	private AccountService accountService;

	@PostMapping("/via/account-numbers")
	public TransactionResponseDto fundTransfer(@RequestBody TransferBalanceRequest transferBalanceRequest) {
		return accountService.sendMoney(transferBalanceRequest);
	}
	
	@PostMapping("/via/phone-numbers")
	public TransactionResponseDto fundTransferThroughPhoneNos(@RequestBody TransferBalanceUsingPhoneDto transferBalanceUsingPhone) {
		return accountService.sendMoneyThroughPhoneNos(transferBalanceUsingPhone);
		
	}

	
	@GetMapping("/statemet")
	public List<Transaction> getStatement(@RequestParam int accNo, Integer year, Integer month){
		return accountService.getAccountStatement(accNo, year, month);

	}
	
	
//	@GetMapping("/statemet/{accNo}")
//	public List<Transaction> getStatement(@PathVariable int accNo){
//		return accountService.getAccountStatement(accNo);
//		
//	}

}
