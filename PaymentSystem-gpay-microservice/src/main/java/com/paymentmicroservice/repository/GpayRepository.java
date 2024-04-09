package com.paymentmicroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paymentmicroservice.entity.Transaction;

public interface GpayRepository extends JpaRepository<Transaction, Integer> {

	List<Transaction> findByFromPhoneNo(String phoneNo);

}
