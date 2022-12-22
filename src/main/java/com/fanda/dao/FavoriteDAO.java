package com.fanda.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fanda.entity.Favorite;
import com.fanda.entity.Food;



public interface FavoriteDAO extends JpaRepository<Favorite, Integer>{
	@Query(value = "SELECT * FROM favorite where username like ?1 ", nativeQuery = true)
	List<Favorite> favorites(String username);
	
	@Query(value = "SELECT * FROM favorite where username like ?1 and food_id = ?2 ", nativeQuery = true)
	Optional<Favorite> favorites_food(String username,Integer food_id);
	
	@Query("SELECT f.food FROM Favorite f WHERE f.account.username = :id")
	List<Food> listfFavorites(String id);
}
