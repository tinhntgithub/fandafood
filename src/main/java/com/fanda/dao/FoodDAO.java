package com.fanda.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fanda.entity.Food;



public interface FoodDAO extends JpaRepository<Food, Integer>{
	@Query("select p from Food p where p.name like ?1")
	List<Food> findkeys(String tensp);
	
	@Query(value="SELECT * FROM fandafood.food where menu_cate_id in (SELECT menu_id FROM fandafood.menu_cate where restaurant_id = ?1);",nativeQuery=true)
	List<Food> getListFoodByResId(Integer idRestaurant);
	
	
}
