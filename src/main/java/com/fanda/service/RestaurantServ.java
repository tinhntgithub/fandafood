package com.fanda.service;

import java.util.List;
import java.util.Optional;

import com.fanda.entity.Restaurant;



public interface RestaurantServ {
	public List<Restaurant> findAll();
	public Optional<Restaurant> findById(int id);
	public Restaurant create(Restaurant Restaurant);
	public Restaurant update (Restaurant Restaurant);	
	public void delete(int Restaurant);
}
