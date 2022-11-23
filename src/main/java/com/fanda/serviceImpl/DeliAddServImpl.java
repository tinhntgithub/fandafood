package com.fanda.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fanda.dao.DeliveryAddressDAO;
import com.fanda.entity.Delivery_address;
import com.fanda.service.DeliAddServ;


@Service
public class DeliAddServImpl implements DeliAddServ {
	@Autowired
	DeliveryAddressDAO dao;
	
	@Override
	public List<Delivery_address> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<Delivery_address> findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public Delivery_address create(Delivery_address delivery_id) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(delivery_id);
	}

	@Override
	public Delivery_address update(Delivery_address delivery_id) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(delivery_id);
	}

	@Override
	public void delete(int delivery_id) {
		// TODO Auto-generated method stub
		dao.deleteById(delivery_id);
	}

}
