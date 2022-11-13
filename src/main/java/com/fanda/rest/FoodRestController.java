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
@RequestMapping("/rest/food")
public class FoodRestController {
	@Autowired
	FoodService fServ;
	
	
	@GetMapping()
	public List<Food> getAll() {
		return fServ.findAll();
	}
	@GetMapping("{id}")
	public Food getById(@PathVariable("id") String id) {
		return fServ.findById(id);
	}
	@PostMapping
	public Food create(@RequestBody Food f) {
		return fServ.create(f);
	}
	
	@PutMapping("{id}")
	public Food update(@PathVariable("id") String id, @RequestBody Food f) {
		return fServ.update(f);
	}
	

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") String id) {
		fServ.delete(id);
	}
}
