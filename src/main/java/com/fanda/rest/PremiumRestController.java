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

import com.fanda.entity.premiumBundle;
import com.fanda.service.PremiumBundleServ;
import com.fanda.serviceImpl.PremiumBundleServImpl;

@RestController
@RequestMapping("/rest/pre")
public class PremiumRestController {
	@Autowired
	PremiumBundleServ pServ;
	
	
	@GetMapping()
	public List<premiumBundle> getAll() {
		return pServ.findAll();
	}
	@GetMapping("{id}")
	public Optional<premiumBundle> getById(@PathVariable("id") int id) {
		return pServ.findById(id);
	}
	@PostMapping
	public premiumBundle create(@RequestBody premiumBundle o) {
		return pServ.create(o);
	}
	
	@PutMapping("{id}")
	public premiumBundle update(@PathVariable("id") String id, @RequestBody premiumBundle o) {
		return pServ.update(o);
	}
	

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") int id) {
		pServ.delete(id);
	}
}
