package com.fanda.service;
import org.springframework.http.ResponseEntity;
import com.fanda.entity.Food;
import com.fasterxml.jackson.databind.JsonNode;

public interface FoodService {
Food create(JsonNode orderData);
	
	public ResponseEntity<Void> delete(Integer id);
}
