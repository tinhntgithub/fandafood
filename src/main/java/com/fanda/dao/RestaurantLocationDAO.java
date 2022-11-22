package com.fanda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fanda.entity.RestaurantLocation;

public interface RestaurantLocationDAO extends JpaRepository<RestaurantLocation, Integer>{

}
