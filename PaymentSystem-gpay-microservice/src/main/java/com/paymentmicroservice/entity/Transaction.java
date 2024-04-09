package com.paymentmicroservice.entity;

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
    private String fromPhoneNo;
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(Integer transactionId, String fromPhoneNo, String toPhoneNo, BigDecimal amount, String comments,
			Date dateTime) {
		super();
		this.transactionId = transactionId;
		this.fromPhoneNo = fromPhoneNo;
		this.toPhoneNo = toPhoneNo;
		this.amount = amount;
		this.comments = comments;
		this.dateTime = dateTime;
	}

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public String getFromPhoneNo() {
		return fromPhoneNo;
	}

	public void setFromPhoneNo(String fromPhoneNo) {
		this.fromPhoneNo = fromPhoneNo;
	}

	public String getToPhoneNo() {
		return toPhoneNo;
	}

	public void setToPhoneNo(String toPhoneNo) {
		this.toPhoneNo = toPhoneNo;
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

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	private String toPhoneNo;

	BigDecimal amount;
	private String comments;
	
	@Temporal(TemporalType.DATE)
	private Date dateTime= new Date(System.currentTimeMillis());

}
