package com.bankapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dtos.accountdtos.AccountResponseDto;
import com.bankapp.dtos.customerdtos.CustomerRequestDto;
import com.bankapp.dtos.customerdtos.CustomerResponseDto;
import com.bankapp.entities.Customer;
import com.bankapp.service.CustomerService;

@RestController
@RequestMapping("/Registration")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private AccountController accountController;
	
	@PostMapping("/customer/create")
	public AccountResponseDto createCustomer(@Valid @RequestBody CustomerRequestDto customerRequestDto) {
		
		return customerService.createCustomer(customerRequestDto);
		
		//accountController.createAccount(customer.getAccount().getAccId(), (double) 10000, (long) 123456);
	}

}
