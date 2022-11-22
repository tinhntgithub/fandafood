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

import com.fanda.entity.Restaurant;
import com.fanda.service.RestaurantServ;
import com.fanda.serviceImpl.RestaurantServImpl;

@RestController
@RequestMapping("/rest/restaurant")
public class RestaurantRestController {
	@Autowired
	RestaurantServ rServ;
	
	
	@GetMapping()
	public List<Restaurant> getAll() {
		return rServ.findAll();
	}
	@GetMapping("{id}")
	public Optional<Restaurant> getById(@PathVariable("id") int id) {
		return rServ.findById(id);
	}
	@PostMapping
	public Restaurant create(@RequestBody Restaurant o) {
		return rServ.create(o);
	}
	
	@PutMapping("{id}")
	public Restaurant update(@PathVariable("id") String id, @RequestBody Restaurant o) {
		return rServ.update(o);
	}
	

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") int id) {
		rServ.delete(id);
	}
}
