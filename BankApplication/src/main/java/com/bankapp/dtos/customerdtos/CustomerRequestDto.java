package com.bankapp.dtos.customerdtos;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.bankapp.dtos.accountdtos.AccountRequestDto;
import com.bankapp.entities.Account;


public class CustomerRequestDto {
	
	//private int customerId;
	
	@NotNull(message = "First name is mandatory.")
	@Size(min = 3, message = "first name should have at least 3 characters")
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
	
	@NotNull
	@Size(min = 6, message = "password should have at least 6 characters")
	private String password;
	
	

//	public int getCustomerId() {
//		return customerId;
//	}
//
//	public void setCustomerId(int customerId) {
//		this.customerId = customerId;
//	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CustomerRequestDto(
			@NotNull(message = "First name is mandatory.") @Size(min = 3, message = "first name should have at least 3 characters") String firstName,
			String lastName, @NotEmpty(message = "gender is mandatory.") String gender,
			@NotNull(message = "age is mandatory.") @Min(18) int age,
			@NotNull(message = "phone no is mandatory.") @Size(min = 10, max = 11) String phoneNo,
			@NotEmpty @Email String email,
			@NotNull @Size(min = 6, message = "password should have at least 6 characters") String password)
			 {
		super();
		//this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.phoneNo = phoneNo;
		this.email = email;
		this.password = password;
		
	}

	public CustomerRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
