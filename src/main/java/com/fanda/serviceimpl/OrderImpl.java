package com.fanda.serviceimpl;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.fanda.dao.FoodDAO;
import com.fanda.dao.OrderDAO;
import com.fanda.dao.OrderDetailDAO;
import com.fanda.entity.Order;
import com.fanda.entity.Food;
import com.fanda.entity.Order_detail;
import com.fanda.service.OrderService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OrderImpl implements OrderService{
	@Autowired
	OrderDAO dao;
	@Autowired
	OrderDetailDAO orderDetailDao;
	@Autowired
	FoodDAO foodDao;

	@Override
	public Order create(JsonNode orderData) {
		ObjectMapper objectMapper = new ObjectMapper();
		Order order = objectMapper.convertValue(orderData, Order.class);
		
	dao.saveAndFlush(order);

		TypeReference<List<Order_detail>> type = new TypeReference<List<Order_detail>>() {
		};
		List<Order_detail> details = objectMapper.convertValue(orderData.get("orderDetails"), type).stream().peek(d -> {
			d.setOrder(order);
			d.setPrice(d.getPrice() * d.getQuantity());
			Optional<Food> product = foodDao.findById(d.getProduct().getMasanpham());             
			product.get().setQty((product.get().getQty()-d.getQuantity()));
			foodDao.saveAndFlush(product.get());
		}).collect(Collectors.toList());

		orderDetailDao.saveAllAndFlush(details);

		return order;
	}
}
