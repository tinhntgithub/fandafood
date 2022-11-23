package com.fanda.service;

import java.util.List;
import java.util.Optional;

import com.fanda.entity.Delivery_address;

public interface DeliAddServ {
	public List<Delivery_address> findAll();
	public Optional<Delivery_address> findById(int id);
	public Delivery_address create(Delivery_address cart);
	public Delivery_address update (Delivery_address cart);	
	public void delete(int cart);
}
