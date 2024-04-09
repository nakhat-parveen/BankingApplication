package com.bankapp.service;

import com.bankapp.dtos.accountdtos.AccountResponseDto;
import com.bankapp.dtos.customerdtos.CustomerRequestDto;
import com.bankapp.dtos.customerdtos.CustomerResponseDto;
import com.bankapp.entities.Customer;

public interface CustomerService {
	public AccountResponseDto createCustomer(CustomerRequestDto customerRequestDto);
}
