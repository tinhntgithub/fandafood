package com.fanda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fanda.entity.Food;

public interface FoodDAO extends JpaRepository<Food, Integer>{

}
