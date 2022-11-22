package com.fanda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fanda.entity.FoodCategory;

public interface FoodCategoryDAO extends JpaRepository<FoodCategory, Integer>{

}
