package com.fanda.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fanda.dao.FoodDAO;
import com.fanda.entity.Food;
import com.fanda.service.FoodServ;

@Service
public class FoodServImpl implements FoodServ{
	
	@Autowired
	FoodDAO dao;
	@Override
	public List<Food> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
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
	public Optional<Food> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

}
