package com.fanda.service;

import java.util.List;
import java.util.Optional;

import com.fanda.entity.Order;



public interface OrderServ {
	public List<Order> findAll();
	public Optional<Order> findById(int id);
	public Order create(Order Order_detail);
	public Order update (Order Order_detail);	
	public void delete(int Menu_cate);
}
