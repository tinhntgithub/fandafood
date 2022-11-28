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

import com.fanda.entity.Review;
import com.fanda.service.ReviewServ;
import com.fanda.serviceImpl.ReviewServImpl;

@RestController
@RequestMapping("/rest/review")
public class ReviewRestController {
	@Autowired
	ReviewServ rServ;

	
	
	@GetMapping()
	public List<Review> getAll() {
		return rServ.findAll();
	}
	@GetMapping("{id}")
	public Optional<Review> getById(@PathVariable("id") int id) {
		return rServ.findById(id);
	}
	@PostMapping
	public Review create(@RequestBody Review o) {
		return rServ.create(o);
	}
	
	@PutMapping("{id}")
	public Review update(@PathVariable("id") String id, @RequestBody Review o) {
		return rServ.update(o);
	}
	

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") int id) {
		rServ.delete(id);
	}
}
