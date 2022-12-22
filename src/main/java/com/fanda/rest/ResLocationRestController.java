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

import com.fanda.entity.RestaurantLocation;
import com.fanda.service.RestaurantLocationServ;
import com.fanda.serviceImpl.RestaurantLocationServImpl;

@RestController
@RequestMapping("/rest/resloca")
public class ResLocationRestController {
	@Autowired
	RestaurantLocationServ rServ;
	
	
	@GetMapping()
	public List<RestaurantLocation> getAll() {
		return rServ.findAll();
	}
	@GetMapping("{id}")
	public Optional<RestaurantLocation> getById(@PathVariable("id") int id) {
		return rServ.findById(id);
	}
	@PostMapping
	public RestaurantLocation create(@RequestBody RestaurantLocation o) {
		return rServ.create(o);
	}
	
	@PutMapping("{id}")
	public RestaurantLocation update(@PathVariable("id") String id, @RequestBody RestaurantLocation o) {
		return rServ.update(o);
	}
	

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") int id) {
		rServ.delete(id);
	}
}
