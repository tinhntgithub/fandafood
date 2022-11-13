package com.fanda.rest;

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
@RequestMapping("/rest/pre")
public class PremiumRestController {
	@Autowired
	PremiumBundleService pServ;
	
	
	@GetMapping()
	public List<PremiumBundle> getAll() {
		return pServ.findAll();
	}
	@GetMapping("{id}")
	public PremiumBundle getById(@PathVariable("id") String id) {
		return PremiumBundle.findById(id);
	}
	@PostMapping
	public PremiumBundle create(@RequestBody PremiumBundle o) {
		return pServ.create(o);
	}
	
	@PutMapping("{id}")
	public PremiumBundle update(@PathVariable("id") String id, @RequestBody PremiumBundle o) {
		return pServ.update(o);
	}
	

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") String id) {
		pServ.delete(id);
	}
}
