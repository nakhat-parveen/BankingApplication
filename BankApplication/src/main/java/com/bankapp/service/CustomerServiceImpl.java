package com.bankapp.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.dtos.accountdtos.AccountResponseDto;
import com.bankapp.dtos.customerdtos.CustomerRequestDto;
import com.bankapp.dtos.customerdtos.CustomerResponseDto;
import com.bankapp.entities.Account;
import com.bankapp.entities.Customer;
import com.bankapp.repository.AccountRepository;
import com.bankapp.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepo;
	@Autowired
	private AccountRepository accountRepo;
	

	@Override
	@Transactional
	public AccountResponseDto createCustomer(CustomerRequestDto customerRequestDto) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerRequestDto, customer);
		List<Account> accList= new ArrayList<>();
		Account account =new Account();
		int accNo = account.getAccNo();
		account.setAccNo(accNo);
		account.setBalance(BigDecimal.valueOf(10000));
		
		account.setPhoneNo(customer.getPhoneNo());
		account.setCustomer(customer);
		accList.add(account);
	    accountRepo.saveAll(accList);
		customer.setAccounts(accList);
		 
		Customer customerDb=customerRepo.save(customer);
		AccountResponseDto accountResponseDto=new AccountResponseDto();
		int accountNumber= account.getAccNo() ;
		accountResponseDto.setAccNo(accountNumber);
		return accountResponseDto;
	}

}
