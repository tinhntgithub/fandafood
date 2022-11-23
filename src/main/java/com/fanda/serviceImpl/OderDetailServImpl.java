package com.fanda.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fanda.dao.OrderDetailDAO;
import com.fanda.entity.Order_detail;
import com.fanda.service.OrderDetailServ;

@Service
public class OderDetailServImpl implements OrderDetailServ {
	
	@Autowired
	OrderDetailDAO dao;
	@Override
	public List<Order_detail> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<Order_detail> findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public Order_detail create(Order_detail Order_detail) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(Order_detail);
	}

	@Override
	public Order_detail update(Order_detail Order_detail) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(Order_detail);
	}

	@Override
	public void delete(int order_detail) {
		// TODO Auto-generated method stub
		dao.deleteById(order_detail);
	}

}
