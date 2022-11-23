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

import com.fanda.entity.Order;
import com.fanda.service.OrderServ;
import com.fanda.serviceImpl.OrderServImpl;

@RestController
@RequestMapping("/rest/order")
public class OrderRestController {
	@Autowired
	OrderServ oServ;
	
	
	@GetMapping()
	public List<Order> getAll() {
		return oServ.findAll();
	}
	@GetMapping("{id}")
	public Optional<Order> getById(@PathVariable("id") int id) {
		return oServ.findById(id);
	}
	@PostMapping
	public Order create(@RequestBody Order o) {
		return oServ.create(o);
	}
	
	@PutMapping("{id}")
	public Order update(@PathVariable("id") String id, @RequestBody Order o) {
		return oServ.update(o);
	}
	

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") int id) {
		oServ.delete(id);
	}
}
