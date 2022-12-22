package com.fanda.service;

import java.util.List;
import java.util.Optional;


import com.fanda.entity.Review;

public interface ReviewServ {
	public List<Review> findAll();
	public Optional<Review> findById(int id);
	public Review create(Review Review);
	public Review update (Review Review);	
	public void delete(int Review);
}
