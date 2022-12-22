package com.fanda.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fanda.dao.AccountDAO;
import com.fanda.dao.AuthorityDAO;
import com.fanda.dao.RoleDAO;
import com.fanda.entity.Account;
import com.fanda.entity.Authority;
import com.fanda.entity.Role;
import com.fanda.service.AccountServ;


@Service
public class AccountServImpl implements AccountServ {
	
	@Autowired
	AccountDAO dao;
		
	@Autowired
	RoleDAO roleDao;
	
	@Autowired
	AuthorityDAO authoritiesDao;
	
	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<Account> findById(String id) {
		
		return dao.findById(id);
	}

	@Override
	public Account create(Account acc) {
		Role role = roleDao.findById(2).get();
		 Authority authority = new Authority();
		authority.setAccount(acc);
		authority.setRole(role);
		dao.saveAndFlush(acc);
		authoritiesDao.saveAndFlush(authority);
		return dao.findById(acc.getUsername()).get();
				
	}

	@Override
	public Account update(Account acc) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(acc);
	}

	@Override
	public void delete(String user) {
		// TODO Auto-generated method stub
		dao.deleteById(user);
	}
	@Override
	public List<Account> getAdminAccounts() {
		// TODO Auto-generated method stub
		return dao.getAdminAccounts();
	}
	@Override
	public List<Authority> getAuthorOfAdmin() {
			List<Account> accounts = dao.getAdminAccounts();
		return dao.getAuthorritiesAdmin(accounts);
	}

}
