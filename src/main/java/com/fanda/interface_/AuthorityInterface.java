package com.fanda.interface_;

import java.util.List;
import java.util.Optional;


import com.fanda.entity.Authority;



public interface AuthorityInterface {

	public List<Authority> findAll();
	public Optional<Authority> findById(int id);
	public Authority create(Authority auth);
	public Authority update (Authority auth);	
	public void delete(int auth);
}
