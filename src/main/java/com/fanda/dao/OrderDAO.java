package com.fanda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fanda.entity.Order;

public interface OrderDAO extends JpaRepository<Order, Integer>{

}
