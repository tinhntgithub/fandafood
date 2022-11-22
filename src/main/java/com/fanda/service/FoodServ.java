package com.fanda.service;

import java.util.List;
import java.util.Optional;

import com.fanda.entity.Food;

public interface FoodServ {
	public List<Food> findAll();
	public Optional<Food> findById(Integer id);
	public Food create(Food Food);
	public Food update (Food Food);	
	public void delete(Integer id);
}
