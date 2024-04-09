package com.bankapp.dtos.customerdtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.bankapp.entities.Account;

public class CustomerResponseDto {
private int customerId;
	
	@NotNull(message = "First name is mandatory.")
	@Size(min = 2, message = "first name should have at least 2 characters")
	private String firstName;
	private String lastName;
	
	@NotEmpty(message = "gender is mandatory.")
	private String gender;
	
	@NotNull(message = "age is mandatory.")
	@Min(18)
	private int age;
	
	@NotNull(message = "phone no is mandatory.")
	@Size(min = 10, max = 11)
	private String phoneNo;
	
	@NotEmpty
	@Email
	private String email;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CustomerResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

//	private int accNo;
//
//	public int getAccNo() {
//		return accNo;
//	}
//
//	public void setAccNo(int accNo) {
//		this.accNo = accNo;
//	}
//
//	public CustomerResponseDto(int accNo) {
//		super();
//		this.accNo = accNo;
//	}
//
//	public CustomerResponseDto() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
	
}
