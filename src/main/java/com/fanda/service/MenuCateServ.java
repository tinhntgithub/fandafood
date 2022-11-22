package com.fanda.service;

import java.util.List;
import java.util.Optional;

import com.fanda.entity.Menu_cate;



public interface MenuCateServ {
	public List<Menu_cate> findAll();
	public Optional<Menu_cate> findById(int id);
	public Menu_cate create(Menu_cate Menu_cate);
	public Menu_cate update (Menu_cate Menu_cate);	
	public void delete(int Menu_cate);
}
