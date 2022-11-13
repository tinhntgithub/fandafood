package com.fanda.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/auth")
public class AuthorityRestController {
	@Autowired
	AuthorityService authServ;
	
	
	@GetMapping()
	public List<Authority> getAllAuthority() {
		return authServ.findAll();
	}
	@GetMapping("{id}")
	public Authority getById(@PathVariable("id") String id) {
		return authServ.findById(id);
	}
	@PostMapping
	public Authority create(@RequestBody Authority auth) {
		return authServ.create(auth);
	}
	
	@PutMapping("{id}")
	public Account update(@PathVariable("id") String id, @RequestBody Account acc) {
		return accServ.update(acc);
	}
	

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") String id) {
		authServ.delete(id);
	}
}
