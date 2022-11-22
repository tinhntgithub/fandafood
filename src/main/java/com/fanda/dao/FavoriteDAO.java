package com.fanda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fanda.entity.Favorite;

public interface FavoriteDAO extends JpaRepository<Favorite, Integer>{

}
