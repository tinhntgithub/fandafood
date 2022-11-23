package com.fanda.service;

import java.util.List;
import java.util.Optional;

import com.fanda.entity.Picture;



public interface PictureServ {
	public List<Picture> findAll();
	public Optional<Picture> findById(int id);
	public Picture create(Picture Picture);
	public Picture update (Picture Picture);	
	public void delete(int Picture);
}
