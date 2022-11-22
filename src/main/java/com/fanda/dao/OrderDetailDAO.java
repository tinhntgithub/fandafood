package com.fanda.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.fanda.entity.Order_detail;

public interface OrderDetailDAO extends JpaRepository<Order_detail, Integer>{

}
