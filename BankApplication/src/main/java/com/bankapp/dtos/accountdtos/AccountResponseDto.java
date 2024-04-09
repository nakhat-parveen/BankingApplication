package com.bankapp.dtos.accountdtos;

import java.math.BigDecimal;

public class AccountResponseDto {
	
	private int accNo;

	//private BigDecimal balance;
	
	public AccountResponseDto(int accNo ) {
		super();
		this.accNo = accNo;
		//this.balance = balance;
	}

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

//	public BigDecimal getBalance() {
//		return balance;
//	}
//
//	public void setBalance(BigDecimal balance) {
//		this.balance = balance;
//	}

	public AccountResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
