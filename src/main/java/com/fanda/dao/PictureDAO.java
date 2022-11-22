package com.fanda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fanda.entity.Picture;

public interface PictureDAO extends JpaRepository<Picture, Integer>{

}
