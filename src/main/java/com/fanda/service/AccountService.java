package com.fanda.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.fanda.entity.Account;
import com.fanda.entity.Authority;
public interface AccountService {
	public  ResponseEntity<Void> delete(String id);
	public List<Account> getAdminAccounts();
	public List<Authority> getAuthorOfAdmin();
}
