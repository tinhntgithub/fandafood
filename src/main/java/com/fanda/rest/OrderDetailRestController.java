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

import com.fanda.entity.Order_detail;
import com.fanda.service.Order_detail_Service;

@RestController
@RequestMapping("/rest/odetail")
public class OrderDetailRestController {
	@Autowired
	Order_detail_Service odServ;
	
	
	@GetMapping()
	public List<Order_detail> getAll() {
		return odServ.findAll();
	}
	@GetMapping("{id}")
	public Optional<Order_detail> getById(@PathVariable("id") int id) {
		return odServ.findById(id);
	}
	@PostMapping
	public Order_detail create(@RequestBody Order_detail o) {
		return odServ.create(o);
	}
	
	@PutMapping("{id}")
	public Order_detail update(@PathVariable("id") String id, @RequestBody Order_detail o) {
		return odServ.update(o);
	}
	

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") int id) {
		odServ.delete(id);
	}
}
