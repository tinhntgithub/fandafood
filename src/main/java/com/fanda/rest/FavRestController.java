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
@RequestMapping("/rest/fav")
public class FavRestController {
	@Autowired
	FavoriteSevice favServ;
	
	
	@GetMapping()
	public List<Favorite> getAll() {
		return favServ.findAll();
	}
	@GetMapping("{id}")
	public Favorite getById(@PathVariable("id") String id) {
		return favServ.findById(id);
	}
	@PostMapping
	public Favorite create(@RequestBody favServ fav) {
		return favServ.create(auth);
	}
	
	@PutMapping("{id}")
	public Favorite update(@PathVariable("id") String id, @RequestBody Favorite fav) {
		return favServ.update(fav);
	}
	

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") String id) {
		favServ.delete(id);
	}
}
