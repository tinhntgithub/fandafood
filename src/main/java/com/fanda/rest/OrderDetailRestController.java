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
@RequestMapping("/rest/odetail")
public class OrderDetailRestController {
	@Autowired
	OrderDetailService odServ;
	
	
	@GetMapping()
	public List<OrderDetail> getAll() {
		return odServ.findAll();
	}
	@GetMapping("{id}")
	public OrderDetail getById(@PathVariable("id") String id) {
		return odServ.findById(id);
	}
	@PostMapping
	public OrderDetail create(@RequestBody OrderDetail o) {
		return odServ.create(o);
	}
	
	@PutMapping("{id}")
	public OrderDetail update(@PathVariable("id") String id, @RequestBody OrderDetail o) {
		return odServ.update(o);
	}
	

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") String id) {
		oServ.delete(id);
	}
}
