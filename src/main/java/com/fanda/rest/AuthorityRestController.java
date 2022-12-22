package com.fanda.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fanda.entity.Authority;
import com.fanda.service.AuthorityServ;
import com.fanda.serviceImpl.AccountServImpl;
import com.fanda.serviceImpl.AuthorityServImpl;

@RestController
@RequestMapping("/rest/auth")
public class AuthorityRestController {
	@Autowired
	AuthorityServ authServ;
	
	
	@GetMapping()
	public List<Authority> getAllAuthority() {
		return authServ.findAll();
	}
	@GetMapping("{id}")
	public Optional<Authority> getById(@PathVariable("id") int id) {
		return authServ.findById(id);
	}
	@PostMapping
	public Authority create(@RequestBody Authority auth) {
		return authServ.create(auth);
	}
	
	@PutMapping("{id}")
	public Authority update(@PathVariable("id") int id, @RequestBody Authority acc) {
		return authServ.update(acc);
	}
	

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") int id) {
		authServ.delete(id);
	}
}
