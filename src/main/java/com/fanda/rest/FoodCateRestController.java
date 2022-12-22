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

import com.fanda.entity.FoodCategory;
import com.fanda.service.FoodCateServ;
import com.fanda.serviceImpl.FoodCategoryServImpl;

@RestController
@RequestMapping("/rest/foodcate")
public class FoodCateRestController {
	@Autowired
	FoodCateServ fcServ;
	
	
	@GetMapping()
	public List<FoodCategory> getAll() {
		return fcServ.findAll();
	}
	@GetMapping("{id}")
	public Optional<FoodCategory> getById(@PathVariable("id") int id) {
		return fcServ.findById(id);
	}
	@PostMapping
	public FoodCategory create(@RequestBody FoodCategory f) {
		return fcServ.create(f);
	}
	
	@PutMapping("{id}")
	public FoodCategory update(@PathVariable("id") String id, @RequestBody FoodCategory f) {
		return fcServ.update(f);
	}
	

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") int id) {
		fcServ.delete(id);
	}
}
