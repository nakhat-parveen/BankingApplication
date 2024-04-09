package com.bankapp.dtos.accountdtos;

import java.math.BigDecimal;

import javax.validation.constraints.Min;

import com.bankapp.entities.Customer;

public class AccountRequestDto {
	//private int accId;
	
	private BigDecimal balance;

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public AccountRequestDto(BigDecimal balance) {
		super();
		this.balance = balance;
	}

	public AccountRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
