package com.fanda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fanda.entity.Account;
import com.fanda.entity.Authority;


public interface AccountServ {
	
	public List<Account> findAll();
	public Optional<Account> findById(String id);
	public Account create(Account acc);
	public Account update (Account acc);	
	public void delete(String user);
}
