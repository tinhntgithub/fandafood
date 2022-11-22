package com.fanda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fanda.entity.Review;

public interface ReviewDAO extends JpaRepository<Review, Integer>{

}
