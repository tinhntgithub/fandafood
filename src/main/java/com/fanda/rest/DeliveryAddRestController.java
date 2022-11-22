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

import com.fanda.entity.Delivery_address;
import com.fanda.service.Delivery_address_Sv;
@RestController
@RequestMapping("/rest/deliadd")
public class DeliveryAddRestController {
	@Autowired
	 Delivery_address_Sv deliAddServ;
	
	
	@GetMapping()
	public List<Delivery_address> getAll() {
		return deliAddServ.findAll();
	}
	@GetMapping("{id}")
	public Optional<Delivery_address> getById(@PathVariable("id") int id) {
		return deliAddServ.findById(id);
	}
	@PostMapping
	public Delivery_address create(@RequestBody Delivery_address deli) {
		return deliAddServ.create(deli);
	}
	
	@PutMapping("{id}")
	public Delivery_address update(@PathVariable("id") String id, @RequestBody Delivery_address deli) {
		return deliAddServ.update(deli);
	}
	

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") int id) {
		deliAddServ.delete(id);
	}
}
