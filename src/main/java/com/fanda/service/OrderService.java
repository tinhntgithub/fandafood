package com.fanda.service;

import com.fanda.entity.Order;
import com.fasterxml.jackson.databind.JsonNode;

public interface OrderService {
	Order create(JsonNode orderData);
}
