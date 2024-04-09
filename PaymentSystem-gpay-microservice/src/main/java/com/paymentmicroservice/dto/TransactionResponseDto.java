package com.paymentmicroservice.dto;

public class TransactionResponseDto {
	
	private Integer transactionId;

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public TransactionResponseDto(Integer transactionId) {
		super();
		this.transactionId = transactionId;
	}

	public TransactionResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
