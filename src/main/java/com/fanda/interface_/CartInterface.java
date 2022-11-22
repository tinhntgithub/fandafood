package com.fanda.interface_;

import java.util.List;
import java.util.Optional;

import com.fanda.entity.Cart;



public interface CartInterface {
	public List<Cart> findAll();
	public Optional<Cart> findById(int id);
	public Cart create(Cart cart);
	public Cart update (Cart cart);	
	public void delete(int cart);
}
