package com.fanda.interface_;

import java.util.List;
import java.util.Optional;

import com.fanda.entity.Food;



public interface FoodInterface {
	public List<Food> findAll();
	public Optional<Food> findById(int id);
	public Food create(Food Food);
	public Food update (Food Food);	
	public void delete(int Food);
}
