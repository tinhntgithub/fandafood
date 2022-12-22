package com.fanda.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fanda.entity.Review;


public interface ReviewDAO extends JpaRepository<Review, Integer>{
	@Query(value ="select * from fandafood.review where food_id= ?1", nativeQuery = true)
	List<Review> timDanhGia(Integer id);
	
	@Query(value ="SELECT AVG(rate), COUNT(*) FROM fandafood.review WHERE food_id = ?1", nativeQuery = true)
	Float tbRate(Integer id);
	
	@Query(value ="SELECT COUNT(*) FROM fandafood.review WHERE food_id = ?1", nativeQuery = true)
	String soLuong(Integer id);
	
	@Query(value ="SELECT * FROM fandafood.review where restaurant_id = ?1", nativeQuery = true)
	List<Review> timDanhGiaNhaHang(Integer id);
	
	@Query(value="select * from review r where r.restaurant_id = ?1 ", nativeQuery=true)
	List<Review> findByRestaurant(int id);
	
	@Query(value="SELECT AVG(rate) rate, COUNT(*) count FROM fandafood.review WHERE restaurant_id = ?1", nativeQuery=true)
	Object[] findTatolReview(Integer id);

}
