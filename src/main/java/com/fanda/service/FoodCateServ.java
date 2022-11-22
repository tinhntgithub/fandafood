package com.fanda.service;

import java.util.List;
import java.util.Optional;

import com.fanda.entity.FoodCategory;



public interface FoodCateServ {
	public List<FoodCategory> findAll();
	public Optional<FoodCategory> findById(int id);
	public FoodCategory create(FoodCategory foodcate);
	public FoodCategory update (FoodCategory foodcate);	
	public void delete(int foodcate);
}
