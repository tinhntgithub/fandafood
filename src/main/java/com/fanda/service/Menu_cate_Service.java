package com.fanda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fanda.dao.MenuCategoryDAO;
import com.fanda.entity.Menu_cate;
import com.fanda.interface_.MenuCateInterface;

@Service
public class Menu_cate_Service implements MenuCateInterface{
	
	@Autowired
	MenuCategoryDAO dao;
	@Override
	public List<Menu_cate> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<Menu_cate> findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public Menu_cate create(Menu_cate Menu_cate) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(Menu_cate);
	}

	@Override
	public Menu_cate update(Menu_cate Menu_cate) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(Menu_cate);
	}

	@Override
	public void delete(int Menu_cate) {
		// TODO Auto-generated method stub
		dao.deleteById(Menu_cate);
	}

}
