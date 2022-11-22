package com.fanda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fanda.dao.AccountDAO;
import com.fanda.interface_.AccountService;


@Service
public class AccountSv implements AccountService {
	
	@Autowired
	AccountDAO dao;
	
	@Override
	public List<com.fanda.entity.Account> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<com.fanda.entity.Account> findById(String id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public com.fanda.entity.Account create(com.fanda.entity.Account acc) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(acc);
	}

	@Override
	public com.fanda.entity.Account update(com.fanda.entity.Account acc) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(acc);
	}

	@Override
	public void delete(String user) {
		// TODO Auto-generated method stub
		dao.deleteById(user);
	}

}
