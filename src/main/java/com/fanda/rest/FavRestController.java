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

import com.fanda.entity.Favorite;
import com.fanda.service.Favorite_Sv;

@RestController
@RequestMapping("/rest/fav")
public class FavRestController {
	@Autowired
	Favorite_Sv favServ;
	
	
	@GetMapping()
	public List<Favorite> getAll() {
		return favServ.findAll();
	}
	@GetMapping("{id}")
	public Optional<Favorite> getById(@PathVariable("id") int id) {
		return favServ.findById(id);
	}
	@PostMapping
	public Favorite create(@RequestBody Favorite fav) {
		return favServ.create(fav);
	}
	
	@PutMapping("{id}")
	public Favorite update(@PathVariable("id") String id, @RequestBody Favorite fav) {
		return favServ.update(fav);
	}
	

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") int id) {
		favServ.delete(id);
	}
}
