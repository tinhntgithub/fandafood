package com.fanda.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.fanda.dao.AccountDAO;
import com.fanda.entity.Account;
import com.fanda.entity.Authority;
import com.fanda.dao.AuthorityDAO;
import com.fanda.service.AccountService;

public class AccountImpl implements AccountService {
	@Autowired
	AuthorityDAO authoritiesDao;
	@Autowired
	AccountDAO accountDao;
//	@Override
//	public void delete(String id) {
//		
//		// TODO Auto-generated method stub
//			Authority authority = authoritiesDao.findAccByAuthority(id);
//			accountDao.deleteById(id);
//			authoritiesDao.deleteById(authority.getId());
//			
//	}
	@Override
	public ResponseEntity<Void> delete (@PathVariable("id") String id) {
		try {
			Authority authority = authoritiesDao.findAccByAuthority(id);
			
				accountDao.deleteById(id);
				authoritiesDao.deleteById(authority.getId());
			System.out.println(authority.getAccount().getUsername());
				
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	@Override
	public List<Account> getAdminAccounts() {
		// TODO Auto-generated method stub
		return accountDao.getAdminAccounts();
	}
	@Override
	public List<Authority> getAuthorOfAdmin() {
			List<Account> accounts = accountDao.getAdminAccounts();
		return accountDao.getAuthorritiesAdmin(accounts);
	}
}
