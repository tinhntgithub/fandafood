package com.fanda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fanda.dao.CartDAO;
import com.fanda.entity.Cart;
import com.fanda.interface_.CartInterface;


@Service
public class CartSv implements CartInterface {
		
	@Autowired
	CartDAO dao;

	@Override
	public List<Cart> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<Cart> findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public Cart create(Cart cart) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(cart);
	}

	@Override
	public Cart update(Cart cart) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(cart);
	}

	@Override
	public void delete(int cart) {
		// TODO Auto-generated method stub
		dao.deleteById(cart);
	}

}
