package com.fanda.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fanda.dao.PictureDAO;
import com.fanda.entity.Picture;
import com.fanda.service.PictureServ;

@Service
public class PictureServImpl implements PictureServ{
	@Autowired
	PictureDAO dao;
	@Override
	public List<Picture> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<Picture> findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public Picture create(Picture Picture) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(Picture);
	}

	@Override
	public Picture update(Picture Picture) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(Picture);
	}

	@Override
	public void delete(int Picture) {
		// TODO Auto-generated method stub
		dao.deleteById(Picture);
	}

}
