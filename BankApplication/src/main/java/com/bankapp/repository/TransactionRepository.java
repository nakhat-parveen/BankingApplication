package com.bankapp.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bankapp.entities.Account;
import com.bankapp.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
	
	List<Transaction> findByFromAccountNumber(int fromAccountNumber);
	
	
	
	//@Query("SELECT t FROM com.bankapp.entities.Transaction t WHERE (t.fromAccountNumber)=:accNo AND YEAR(t.dateTime)=:year AND MONTH(t.dateTime)=:month")
	@Query("from Transaction as t where (t.fromAccountNumber)=:accNum and year(t.dateTime)=:year and month(t.dateTime)=:month")
	List<Transaction> getCustomerStatement(int accNum, Integer year, Integer month);
	

}
