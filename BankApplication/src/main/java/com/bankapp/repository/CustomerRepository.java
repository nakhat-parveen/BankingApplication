package com.bankapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankapp.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
