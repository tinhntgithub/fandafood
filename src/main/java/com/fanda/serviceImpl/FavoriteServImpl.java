package com.fanda.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fanda.dao.FavoriteDAO;
import com.fanda.entity.Favorite;
import com.fanda.service.FavoriteServ;


@Service
public class FavoriteServImpl implements FavoriteServ{
	
	@Autowired
	FavoriteDAO dao;
	
	@Override
	public List<Favorite> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<Favorite> findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public Favorite create(Favorite fav) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(fav);
	}

	@Override
	public Favorite update(Favorite fav) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(fav);
	}

	@Override
	public void delete(int fav) {
		// TODO Auto-generated method stub
		dao.deleteById(fav);
	}

}
