package com.fanda.service;

import java.util.List;
import java.util.Optional;

import com.fanda.entity.Account;


public interface AccountServ {
	
	public List<Account> findAll();
	public Optional<Account> findById(String id);
	public Account create(Account acc);
	public Account update (Account acc);	
	public void delete(String user);
}
