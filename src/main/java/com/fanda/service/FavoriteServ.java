package com.fanda.service;

import java.util.List;
import java.util.Optional;

import com.fanda.entity.Favorite;



public interface FavoriteServ {
	public List<Favorite> findAll();
	public Optional<Favorite> findById(int id);
	public Favorite create(Favorite fav);
	public Favorite update (Favorite fav);	
	public void delete(int fav);
}
