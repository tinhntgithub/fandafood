package com.fanda.rest;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fanda.dao.ReviewDAO;
import com.fanda.entity.Review;
import com.fanda.service.ReviewServ;



@RestController
@RequestMapping("/restaurant/review")
public class RestReviewInRestaurant {
	@Autowired
	ReviewServ rServ;
	@Autowired
	ReviewDAO dao;
	
	@GetMapping("{id}")
	public List<Review> getByRestaurant(@PathVariable("id") int id) {
		return dao.findByRestaurant(id);
	}
}
