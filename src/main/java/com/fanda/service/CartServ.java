package com.fanda.service;

import java.util.List;
import java.util.Optional;

import com.fanda.entity.Cart;



public interface CartServ {
	public List<Cart> findAll();
	public Optional<Cart> findById(int id);
	public Cart create(Cart cart);
	public Cart update (Cart cart);	
	public void delete(int cart);
}
