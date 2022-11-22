package com.fanda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.fanda.dao.ReviewDAO;
import com.fanda.entity.Review;
import com.fanda.interface_.ReviewInterface;

public class ReviewService implements ReviewInterface {
	
	@Autowired
	ReviewDAO dao;
	@Override
	public List<Review> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<Review> findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public Review create(Review Review) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(Review);
	}

	@Override
	public Review update(Review Review) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(Review);
	}

	@Override
	public void delete(int Review) {
		// TODO Auto-generated method stub
		dao.deleteById(Review);
	}

}
