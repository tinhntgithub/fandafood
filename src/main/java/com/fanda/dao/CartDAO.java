package com.fanda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Cart;

public interface CartDAO extends JpaRepository<Cart, Integer>{

}