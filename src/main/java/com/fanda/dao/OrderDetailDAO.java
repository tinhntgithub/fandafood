package com.fanda.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fanda.entity.Order_detail;



public interface OrderDetailDAO extends JpaRepository<Order_detail, Integer>{
	@Query(value ="select * from fandafood.order_detail where order_id = ?1", nativeQuery = true)
	List<Order_detail>findDetails(Integer id);

}
