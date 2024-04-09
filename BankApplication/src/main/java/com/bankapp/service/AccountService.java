package com.bankapp.service;

import java.util.Date;
import java.util.List;

import com.bankapp.dtos.accountdtos.AccountRequestDto;
import com.bankapp.entities.Account;
import com.bankapp.entities.Transaction;
import com.bankapp.pojos.TransferBalanceRequest;
import com.bankapp.transactiondto.TransactionResponseDto;
import com.bankapp.transactiondto.TransferBalanceUsingPhoneDto;



public interface AccountService {

	
	TransactionResponseDto sendMoney(TransferBalanceRequest transferBalanceRequest);
	
	TransactionResponseDto sendMoneyThroughPhoneNos(TransferBalanceUsingPhoneDto transferBalanceUsingPhone);

	//List<Transaction> getAccountStatement(int accNo);

	
	List<Transaction> getAccountStatement(int accNo, Integer year, Integer month);
	
	

}
