package com.fanda.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fanda.dao.AuthorityDAO;
import com.fanda.entity.Authority;
import com.fanda.service.AuthorityServ;


@Service
public class AuthorityServImpl implements AuthorityServ {
	
	@Autowired
	AuthorityDAO dao;
	
	@Override
	public List<Authority> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<Authority> findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public Authority create(Authority auth) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(auth);
	}

	@Override
	public Authority update(Authority auth) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(auth);
	}

	@Override
	public void delete(int auth) {
		// TODO Auto-generated method stub
		dao.deleteById(auth);
	}

}
