package com.fanda.rest;

import java.util.List;
import java.util.Optional;

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

import com.fanda.entity.Account;
import com.fanda.service.AccountSv;



@RestController
@RequestMapping("/rest/user")
public class AccountRestController {
	@Autowired
	AccountSv accServ;
	
	
	@GetMapping()
	public List<Account> getAllAccount() {
		return accServ.findAll();
	}
	@GetMapping("{id}")
	public Optional<Account> getAccountById(@PathVariable("id") String id) {
		return accServ.findById(id);
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
