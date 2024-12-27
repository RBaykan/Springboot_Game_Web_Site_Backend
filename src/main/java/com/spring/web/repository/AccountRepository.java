package com.spring.web.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.web.entity.Account;


public interface AccountRepository extends JpaRepository<Account, Long> {
	 Optional<Account> findByUsername(String username);
}
