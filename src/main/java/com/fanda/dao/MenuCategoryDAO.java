package com.fanda.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fanda.entity.Menu_cate;

public interface MenuCategoryDAO extends JpaRepository<Menu_cate, Integer>{
	@Query(value ="select * from fandafood.menu_cate where restaurant_id = ?1", nativeQuery = true)
	List<Menu_cate> timMenu(Integer id);
	

}
