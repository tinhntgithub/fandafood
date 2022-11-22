package com.fanda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fanda.dao.FoodCategoryDAO;
import com.fanda.entity.FoodCategory;
import com.fanda.interface_.FoodCateInterface;

@Service
public class FoodCategoryService implements FoodCateInterface {
	
	@Autowired
	FoodCategoryDAO dao;
	@Override
	public List<FoodCategory> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<FoodCategory> findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public FoodCategory create(FoodCategory foodcate) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(foodcate);
	}

	@Override
	public FoodCategory update(FoodCategory foodcate) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(foodcate);
	}

	@Override
	public void delete(int foodcate) {
		// TODO Auto-generated method stub
		dao.deleteById(foodcate);
	}

}
