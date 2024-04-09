package com.bankapp.pojos;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;




public class TransferBalanceRequest {
	private int fromAccountNumber;

    private int toAccountNumber;

    private BigDecimal amount;
    
    private String comments;
	@Temporal(TemporalType.DATE)
	private Date dateTime= new Date(System.currentTimeMillis());
	

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public int getFromAccountNumber() {
		return fromAccountNumber;
	}

	public void setFromAccountNumber(int fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}

	public int getToAccountNumber() {
		return toAccountNumber;
	}

	public void setToAccountNumber(int toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	

	public TransferBalanceRequest(int fromAccountNumber, int toAccountNumber, BigDecimal amount, String comments,
			Date dateTime) {
		super();
		this.fromAccountNumber = fromAccountNumber;
		this.toAccountNumber = toAccountNumber;
		this.amount = amount;
		this.comments = comments;
		this.dateTime = dateTime;
	}

	public TransferBalanceRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
    

}
