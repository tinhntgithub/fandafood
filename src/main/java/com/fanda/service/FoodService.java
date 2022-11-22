package com.fanda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.fanda.dao.FoodDAO;
import com.fanda.entity.Food;
import com.fanda.interface_.FoodInterface;

public class FoodService implements FoodInterface{
	
	@Autowired
	FoodDAO dao;
	@Override
	public List<Food> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<Food> findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public Food create(Food Food) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(Food);
	}

	@Override
	public Food update(Food Food) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(Food);
	}

	@Override
	public void delete(int Food) {
		// TODO Auto-generated method stub
		dao.deleteById(Food);
	}

}
