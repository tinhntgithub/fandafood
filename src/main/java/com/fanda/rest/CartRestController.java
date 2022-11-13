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
@RequestMapping("/rest/cart")
public class CartRestController {
	@Autowired
	CartService cartServ;
	
	
	@GetMapping()
	public List<Cart> getAllCart() {
		return cartServ.findAll();
	}
	@GetMapping("{id}")
	public Cart getById(@PathVariable("id") String id) {
		return cartServ.findById(id);
	}
	@PostMapping
	public Cart create(@RequestBody cartServ cart) {
		return cartServ.create(auth);
	}
	
	@PutMapping("{id}")
	public Cart update(@PathVariable("id") String id, @RequestBody Cart cart) {
		return cartServ.update(cart);
	}
	

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") String id) {
		cartServ.delete(id);
	}
}
