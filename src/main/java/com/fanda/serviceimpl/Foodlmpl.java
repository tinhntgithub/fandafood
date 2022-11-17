package com.fanda.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fanda.dao.FoodDAO;
import com.fanda.entity.Food;
import com.fanda.entity.Picture;
import com.fanda.service.FoodService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class Foodlmpl implements FoodService{
	@Autowired
	FoodDAO foodDao;
	@Autowired
	ImageDetailDao imageDetailDao;
	
	@Override
	public Food create(JsonNode orderData) {
		ObjectMapper objectMapper = new ObjectMapper();
		Food Food = objectMapper.convertValue(orderData, Food.class);
		
	foodDao.saveAndFlush(Food);
		
		TypeReference<List<Picture>> type = new TypeReference<List<Picture>>() {};
		List<Picture> details = objectMapper.convertValue(orderData.get("imagedetail"), type).stream().peek(d -> {
	
		d.setFood(Food);
		}).collect(Collectors.toList());
		imageDetailDao.saveAllAndFlush(details);
		return Food;
	}

	@Override
	public ResponseEntity<Void>delete(Integer id) {
		
		try {
			foodDao.deleteById(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			System.out.println("Không thể xóa");
			return ResponseEntity.notFound().build();
		}
	}
}
