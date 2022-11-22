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

import com.fanda.entity.Food;
import com.fanda.service.FoodService;

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
	public Optional<Food> getById(@PathVariable("id") int id) {
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
	public void delete(@PathVariable("id") int id) {
		fServ.delete(id);
	}
}
