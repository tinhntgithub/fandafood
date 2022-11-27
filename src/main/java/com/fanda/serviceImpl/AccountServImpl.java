package com.fanda.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fanda.dao.AccountDAO;
import com.fanda.entity.Account;
import com.fanda.service.AccountServ;


@Service
public class AccountServImpl implements AccountServ {
	
	@Autowired
	AccountDAO dao;
	
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
		// TODO Auto-generated method stub
		return dao.saveAndFlush(acc);
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

}
