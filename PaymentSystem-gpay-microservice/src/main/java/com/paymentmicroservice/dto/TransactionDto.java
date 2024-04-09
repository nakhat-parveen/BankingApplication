package com.paymentmicroservice.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class TransactionDto {
	
private BigDecimal amount;
    
    private String comments;
	@Temporal(TemporalType.DATE)
	private Date dateTime= new Date(System.currentTimeMillis());
	
	

	private String fromPhoneNo;
	
	private String toPhoneNo;

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
	
	public TransactionDto(BigDecimal amount, String comments, Date dateTime, String fromPhoneNo, String toPhoneNo) {
		super();
		this.amount = amount;
		this.comments = comments;
		this.dateTime = dateTime;
		this.fromPhoneNo = fromPhoneNo;
		this.toPhoneNo = toPhoneNo;
	}

	public TransactionDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
