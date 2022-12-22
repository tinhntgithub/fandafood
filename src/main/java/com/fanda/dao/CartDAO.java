package com.fanda.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fanda.entity.Cart;



public interface CartDAO extends JpaRepository<Cart, Integer>{
	@Query("select c from Cart c where c.account.username = ?1 and c.food.food_id = ?2 and c.restaurant.restaurantId = ?3")
	Optional<Cart> listCart(String username,Integer masp,Integer restaurantId);
	
	@Query("select c from Cart c where c.account.username = ?1 ")
	List<Cart> listCart(String username);

		@Query(value = "select sum(cart.qty*food.price) from cart \r\n"
			+ "inner join food\r\n"
			+ "on cart.food_id = food.food_id\r\n"
			+ "where username = ?1 and restaraunt_id = ?2" , nativeQuery =  true)
	Double sumCarts(String username ,Integer id);

		@Query("select c from Cart c where c.account.username = ?1 ")
		List<Cart> AccountCart(String username);
		
		@Query("select c from Cart c where c.account.username = ?1 and  c.restaurant.restaurantId = ?2 ")
		List<Cart> AccountCart_Restaraunt(String username,Integer restaurantId);
}
