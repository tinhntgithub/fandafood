package com.fanda.service;

import java.util.List;
import java.util.Optional;



import com.fanda.entity.RestaurantLocation;

public interface RestaurantLocationServ {
	public List<RestaurantLocation> findAll();
	public Optional<RestaurantLocation> findById(int id);
	public RestaurantLocation create(RestaurantLocation RestaurantLocation);
	public RestaurantLocation update (RestaurantLocation RestaurantLocation);	
	public void delete(int RestaurantLocation);
}
