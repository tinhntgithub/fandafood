package com.fanda.service;

import java.util.List;
import java.util.Optional;


import com.fanda.entity.Authority;



public interface AuthorityServ {

	public List<Authority> findAll();
	public Optional<Authority> findById(int id);
	public Authority create(Authority auth);
	public Authority update (Authority auth);	
	public void delete(int auth);
}
