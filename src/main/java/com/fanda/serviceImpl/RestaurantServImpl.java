package com.fanda.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fanda.dao.RestaurantDAO;
import com.fanda.entity.Restaurant;
import com.fanda.service.RestaurantServ;

@Service
public class RestaurantServImpl implements RestaurantServ {
	
	@Autowired
	RestaurantDAO dao;
	@Override
	public List<Restaurant> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<Restaurant> findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public Restaurant create(Restaurant Restaurant) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(Restaurant);
	}

	@Override
	public Restaurant update(Restaurant Restaurant) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(Restaurant);
	}

	@Override
	public void delete(int Restaurant) {
		// TODO Auto-generated method stub
		dao.deleteById(Restaurant);
	}

}
