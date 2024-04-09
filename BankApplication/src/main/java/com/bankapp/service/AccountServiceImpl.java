package com.bankapp.service;

import java.math.*;
import java.security.Timestamp;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.controller.CustomerController;
import com.bankapp.dtos.accountdtos.AccountRequestDto;
import com.bankapp.entities.Account;
import com.bankapp.entities.Customer;
import com.bankapp.entities.Transaction;
import com.bankapp.pojos.TransferBalanceRequest;
import com.bankapp.repository.AccountRepository;
import com.bankapp.repository.TransactionRepository;
import com.bankapp.transactiondto.TransactionResponseDto;
import com.bankapp.transactiondto.TransferBalanceUsingPhoneDto;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepo;
	@Autowired
	private TransactionRepository transactionRepository;
	
	

	@Override
	@Transactional
	public TransactionResponseDto sendMoney(TransferBalanceRequest transferBalanceRequest) {
		Transaction transaction = new Transaction();
		BeanUtils.copyProperties(transferBalanceRequest, transaction);

		int fromAccountNumber = transferBalanceRequest.getFromAccountNumber();
		int toAccountNumber = transferBalanceRequest.getToAccountNumber();
		BigDecimal amount = transferBalanceRequest.getAmount();
		Account fromAccount = accountRepo.findByAccNo(fromAccountNumber);
		Account toAccount = accountRepo.findByAccNo(toAccountNumber);

		if (fromAccount.getBalance().compareTo(BigDecimal.ONE) == 1
				&& fromAccount.getBalance().compareTo(amount) == 1) {

			fromAccount.setBalance(fromAccount.getBalance().subtract(transferBalanceRequest.getAmount()));
			accountRepo.save(fromAccount);
			toAccount.setBalance(toAccount.getBalance().add(amount));
			accountRepo.save(toAccount);

			Transaction dbTransaction = transactionRepository.save(transaction);
			TransactionResponseDto transactionResponseDto = new TransactionResponseDto();
			BeanUtils.copyProperties(dbTransaction, transactionResponseDto);
			return transactionResponseDto;

		}

		return null;
	}

	@Override
	public TransactionResponseDto sendMoneyThroughPhoneNos(TransferBalanceUsingPhoneDto transferBalanceUsingPhone) {


		String fromPhoneNo = transferBalanceUsingPhone.getFromPhoneNo();
		String toPhoneNo = transferBalanceUsingPhone.getToPhoneNo();
		BigDecimal amount = transferBalanceUsingPhone.getAmount();
		Account fromAccount = accountRepo.findByPhoneNo(fromPhoneNo);
		Account toAccount = accountRepo.findByPhoneNo(toPhoneNo);
		if (fromAccount.getBalance().compareTo(BigDecimal.ONE) == 1
				&& fromAccount.getBalance().compareTo(amount) == 1) {

			fromAccount.setBalance(fromAccount.getBalance().subtract(transferBalanceUsingPhone.getAmount()));
			accountRepo.save(fromAccount);
			toAccount.setBalance(toAccount.getBalance().add(amount));
			accountRepo.save(toAccount);

//			Transaction transaction = new Transaction();
//			BeanUtils.copyProperties(transferBalanceUsingPhone, transaction);
			
			//Transaction dbTransaction = transactionRepository.save(transaction);
			TransactionResponseDto transactionResponseDto = new TransactionResponseDto();
			//BeanUtils.copyProperties(dbTransaction, transactionResponseDto);
			return transactionResponseDto;

		}

		return null;
	}

	@Override
	public List<Transaction> getAccountStatement(int accNo, Integer year, Integer month) {
		
		return transactionRepository.getCustomerStatement(accNo, year, month);
	}

//	@Override
//	public List<Transaction> getAccountStatement(int accNo) {
//		return transactionRepository.findByFromAccountNumber(accNo);
//
//	}

}
