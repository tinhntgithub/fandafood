package com.fanda.interface_;

import java.util.List;
import java.util.Optional;

import com.fanda.entity.Restaurant;



public interface RestaurantInterface {
	public List<Restaurant> findAll();
	public Optional<Restaurant> findById(int id);
	public Restaurant create(Restaurant Restaurant);
	public Restaurant update (Restaurant Restaurant);	
	public void delete(int Restaurant);
}
