package com.fanda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fanda.entity.Restaurant;

public interface RestaurantDAO extends JpaRepository<Restaurant, Integer>{

}
