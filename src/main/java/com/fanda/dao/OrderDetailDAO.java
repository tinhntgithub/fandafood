package com.fanda.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fanda.entity.Order_detail;

public interface OrderDetailDAO extends JpaRepository<Order_detail, Integer>{
	@Query("select o FROM OrderDetail o where o.order.id = ?1")
	List<Order_detail> ViewOrder(Long id);
	
	@Query("select SUM(o.price * o.quantity) FROM OrderDetail o where o.order.id = ?1")
	Double sumOrder(Long id);
}
