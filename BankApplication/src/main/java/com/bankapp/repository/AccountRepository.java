package com.bankapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankapp.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
           Account findByAccNo(int accNo);
           Account findByPhoneNo(String phoneNo);
}
