package com.fanda.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fanda.entity.Restaurant;



public interface RestaurantDAO extends JpaRepository<Restaurant, Integer>{
	
	@Query(value ="SELECT COUNT(*) FROM fandafood.review WHERE restaurant_id = ?1", nativeQuery = true)
	Integer tongDanhGiaRes(Integer id);
	
	@Query(value ="SELECT * FROM fandafood.restaurant where name like ?1 ;", nativeQuery = true)
	Optional<Restaurant> search(String id);
	
	@Query("select p from Restaurant p where p.name like ?1")
	List<Restaurant> findkeys(String tensp);
	
	@Query(value ="SELECT COUNT(*) FROM fandafood.review WHERE restaurant_id = ?1 and rate = 5", nativeQuery = true)
	Float namsao(Integer id);
	
	@Query(value ="SELECT COUNT(*) FROM fandafood.review WHERE restaurant_id = ?1 and rate = 4", nativeQuery = true)
	Float bonsao(Integer id);
	
	@Query(value ="SELECT COUNT(*) FROM fandafood.review WHERE restaurant_id = ?1 and rate = 3", nativeQuery = true)
	Float basao(Integer id);
	
	@Query(value ="SELECT COUNT(*) FROM fandafood.review WHERE restaurant_id = ?1 and rate = 2", nativeQuery = true)
	Float haisao(Integer id);
	
	@Query(value ="SELECT COUNT(*) FROM fandafood.review WHERE restaurant_id = ?1 and rate = 1", nativeQuery = true)
	Float motsao(Integer id);
	
	@Query(value ="Select avg(rate) from fandafood.review where restaurant_id = ?1", nativeQuery = true)
	Float trungBinh(Integer id);

	@Query(value = "select * from restaurant where user_id = ?1", nativeQuery =true )
	Optional<Restaurant> findByUser(String userid);

}
