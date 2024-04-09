package com.bankapp.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Transaction {
	@Id
	@GeneratedValue
	private Integer transactionId;
	private int fromAccountNumber;
	private int toAccountNumber;
	BigDecimal amount;
	private String comments;
	@Temporal(TemporalType.DATE)
	private Date dateTime= new Date(System.currentTimeMillis());
	
	
	
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public Integer getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
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
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public Transaction(Integer transactionId, int fromAccountNumber, int toAccountNumber, BigDecimal amount, String comments,
			Date dateTime) {
		super();
		this.transactionId = transactionId;
		this.fromAccountNumber = fromAccountNumber;
		this.toAccountNumber = toAccountNumber;
		this.amount = amount;
		this.comments = comments;
		this.dateTime = dateTime;
	}

	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

}
