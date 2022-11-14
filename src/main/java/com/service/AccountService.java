package com.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public interface AccountService {
	
	public List<Account> getAllAccount();
	public List<Authority> getAccountById(String id);
	
	
}
