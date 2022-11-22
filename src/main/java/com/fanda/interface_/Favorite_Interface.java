package com.fanda.interface_;

import java.util.List;
import java.util.Optional;

import com.fanda.entity.Favorite;



public interface Favorite_Interface {
	public List<Favorite> findAll();
	public Optional<Favorite> findById(int id);
	public Favorite create(Favorite fav);
	public Favorite update (Favorite fav);	
	public void delete(int fav);
}
