package com.fanda.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fanda.dao.RestaurantLocationDAO;
import com.fanda.entity.RestaurantLocation;
import com.fanda.service.RestaurantLocationServ;

@Service
public class RestaurantLocationServImpl implements RestaurantLocationServ {
	@Autowired
	RestaurantLocationDAO dao;
	@Override
	public List<RestaurantLocation> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<RestaurantLocation> findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public RestaurantLocation create(RestaurantLocation RestaurantLocation) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(RestaurantLocation);
	}

	@Override
	public RestaurantLocation update(RestaurantLocation RestaurantLocation) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(RestaurantLocation);
	}

	@Override
	public void delete(int RestaurantLocation) {
		// TODO Auto-generated method stub
		dao.deleteById(RestaurantLocation);
	}

}
