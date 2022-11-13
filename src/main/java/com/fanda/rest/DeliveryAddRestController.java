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
@RequestMapping("/rest/deliadd")
public class DeliveryAddRestController {
	@Autowired
	DeliveryAddressService deliAddServ;
	
	
	@GetMapping()
	public List<DeliveryAddress> getAll() {
		return deliAddServ.findAll();
	}
	@GetMapping("{id}")
	public DeliveryAddress getById(@PathVariable("id") String id) {
		return deliAddServ.findById(id);
	}
	@PostMapping
	public DeliveryAddress create(@RequestBody DeliveryAddress deli) {
		return deliAddServ.create(deli);
	}
	
	@PutMapping("{id}")
	public DeliveryAddress update(@PathVariable("id") String id, @RequestBody DeliveryAddress deli) {
		return deliAddServ.update(deli);
	}
	

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") String id) {
		deliAddServ.delete(id);
	}
}
