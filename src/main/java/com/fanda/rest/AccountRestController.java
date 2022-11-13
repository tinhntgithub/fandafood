package com.fanda.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rest/user")
public class AccountRestController {
	@Autowired
	AccountService accServ;
	
	
	@GetMapping()
	public List<Account> getAllAccount() {
		return accServ.findAll();
	}
	@GetMapping("{id}")
	public Account getAccountById(@PathVariable("id") String id) {
		return accServ.findBySDT(id);
	}
	@PostMapping
	public Account create(@RequestBody Account acc) {
		return accServ.create(acc);
	}
	
	@PutMapping("{id}")
	public Account update(@PathVariable("id") String id, @RequestBody Account acc) {
		return accServ.update(acc);
	}
	

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") String id) {
		accServ.delete(id);
	}
}
