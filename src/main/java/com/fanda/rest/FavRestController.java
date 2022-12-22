package com.fanda.rest;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fanda.dao.AccountDAO;
import com.fanda.dao.FavoriteDAO;
import com.fanda.dao.FoodDAO;
import com.fanda.entity.Account;
import com.fanda.entity.Favorite;
import com.fanda.entity.Food;
import com.fanda.service.FavoriteServ;
import com.fanda.serviceImpl.FavoriteServImpl;





@RestController
@RequestMapping("/rest/fav")
public class FavRestController {
	@Autowired
	FavoriteServ favServ;
	@Autowired
	FavoriteDAO dao;
	@Autowired
	FoodDAO fDao;
	@Autowired
	AccountDAO accountDAO;
	@Autowired
	HttpServletRequest request;
	
	
	@GetMapping()
	public List<Favorite> getAll() {
		return dao.favorites(request.getRemoteUser());
	}
	
	
	
	@GetMapping("/food/{id}")
	public Optional<Favorite> getFavorite_food(@PathVariable("id") int id) {
		return dao.favorites_food(request.getRemoteUser() , id);
	}
	
	@GetMapping("/id_fav")
	public String getAllp() {
		List<Food> list = dao.listfFavorites(request.getRemoteUser());
		
		Integer likeid = 0;
		String tensp = "";
			
		Object get = 0;
		for (Food food : list) {
			tensp += food.getName();
		}
		return tensp;
	}
	
	
	@GetMapping("/dislike/{id}")
	public void  dislike(@PathVariable("id") int id) {
		 dao.deleteById(id);
	}
	
	
	@GetMapping("{id}")
	public Optional<Favorite> getById(@PathVariable("id") int id) {
		return favServ.findById(id);
	}
	
	
	
	@PostMapping("/like/{id}")
	public Favorite create(@PathVariable("id") int id ,Favorite favorite) {
		Food food = fDao.findById(id).get();
		Account account = accountDAO.findById( request.getRemoteUser()).get();
		favorite.setAccount(account);
		favorite.setFood(food);
		return favServ.create(favorite);
	}
	
	@PutMapping("{id}")
	public Favorite update(@PathVariable("id") String id, @RequestBody Favorite fav) {
		return favServ.update(fav);
	}
	

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") int id) {
		favServ.delete(id);
	}
}
