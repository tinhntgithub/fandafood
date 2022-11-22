package com.fanda.interface_;

import java.util.List;
import java.util.Optional;

import com.fanda.entity.Order_detail;



public interface OrderDetailInterface {
	public List<Order_detail> findAll();
	public Optional<Order_detail> findById(int id);
	public Order_detail create(Order_detail Order_detail);
	public Order_detail update (Order_detail Order_detail);	
	public void delete(int Menu_cate);
}
