package com.fanda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fanda.dao.OrderDAO;
import com.fanda.entity.Order;
import com.fanda.interface_.OrderInterface;

@Service
public class OrderService implements OrderInterface {

	@Autowired
	OrderDAO dao ;
	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<Order> findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public Order create(Order Order_detail) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(Order_detail);
	}

	@Override
	public Order update(Order Order_detail) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(Order_detail);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

}
