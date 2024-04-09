package com.bankapp.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@SequenceGenerator(name="acc_gen", sequenceName = "acc_gen", initialValue=135791)
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="acc_gen")
	private int accNo;
//	private String phoneNo;
//	public String getPhoneNo() {
//		return phoneNo;
//	}
//
//	public void setPhoneNo(String phoneNo) {
//		this.phoneNo = phoneNo;
//	}

	private BigDecimal balance;
	
//	@Cascade(CascadeType.SAVE_UPDATE)
	@ManyToOne
	@JoinColumn(name="CustomerId")
	private Customer customer;
	
	
	private String phoneNo;

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

//	public Customer getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}

	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(int accNo,BigDecimal balance, Customer customer) {
		super();
		this.accNo = accNo;
		this.balance = balance;
		this.customer = customer;
	}
	
	

}
