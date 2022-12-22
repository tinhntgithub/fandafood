package com.fanda.rest;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fanda.dao.AccountDAO;
import com.fanda.entity.Account;
import com.fanda.service.AccountServ;



@RestController
@RequestMapping("/rest/user")
public class AccountRestController {
	@Autowired
	AccountServ accServ;

	@Autowired
	AccountDAO accDao;
	
	@Autowired
	HttpServletRequest resp;
	
	@GetMapping()
	public List<Account> getAllAccount() {
		return accServ.findAll();
	}
	@GetMapping("{id}")
	public Optional<Account> getAccountById(@PathVariable("id") String id) {
		Optional<Account> acc = accServ.findById(id);
		if(acc.isPresent()){
			return accServ.findById(id);
		}else{
			return null;
		}
	}
	
	@GetMapping("/current")
	public Account curentUser() {
		return accServ.findById(resp.getRemoteUser()).get();
	}

	@PostMapping
	public Account create(@RequestBody Account acc) {
			return accServ.create(acc);
		
	}
	
	@PutMapping
	public Account update(@RequestBody Account acc) {
		return accServ.update(acc);
	}
	

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") String id) {
		accServ.delete(id);
	}
}
