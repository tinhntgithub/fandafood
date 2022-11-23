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

import com.fanda.entity.Cart;
import com.fanda.service.CartServ;
import com.fanda.serviceImpl.CartServImpl;

@RestController
@RequestMapping("/rest/cart")
public class CartRestController {
	@Autowired
	CartServ cartServ;
	
	
	@GetMapping()
	public List<Cart> getAllCart() {
		return cartServ.findAll();
	}
	@GetMapping("{id}")
	public Optional<Cart> getById(@PathVariable("id") int id) {
		return cartServ.findById(id);
	}
	@PostMapping
	public Cart create(@RequestBody Cart cart) {
		return cartServ.create(cart);
	}
	
	@PutMapping("{id}")
	public Cart update(@PathVariable("id") String id, @RequestBody Cart cart) {
		return cartServ.update(cart);
	}
	

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") int id) {
		cartServ.delete(id);
	}
}
