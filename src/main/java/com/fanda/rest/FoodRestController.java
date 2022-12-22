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

import com.fanda.dao.FoodDAO;
import com.fanda.dao.RestaurantDAO;
import com.fanda.entity.Food;
import com.fanda.entity.Restaurant;
import com.fanda.service.FoodServ;

@RestController
@RequestMapping("/rest/food")
public class FoodRestController {
	
	@Autowired
	FoodServ fServ;	
	@Autowired
	FoodDAO dao;
	@Autowired
	RestaurantDAO daoRes;
	@Autowired
	HttpServletRequest request;
	
	@GetMapping()
	public List<Food> getAll() {
		return fServ.findAll();
	}
	@GetMapping("{id}")
	public Optional<Food> getById(@PathVariable("id") int id) {
		
		return dao.findById(id);
	}
	
	
	@GetMapping("/search/{name}")
	public List<Food> getByname(@PathVariable("name") String id) {
		
		return dao.findkeys("%"+id+"%");
	}
	@PostMapping
	public Food create(@RequestBody Food f) {
		return fServ.create(f);
	}
	
	@PutMapping("{id}")
	public Food update(@PathVariable("id") String id, @RequestBody Food f) {
		return fServ.update(f);
	}
	

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") int id) {
		fServ.delete(id);
	}
	
	@GetMapping("/restaurant")
	public List<Food> getByRes() {
		Restaurant res = daoRes.findByUser(request.getRemoteUser()).get();
		return dao.getListFoodByResId(res.getRestaurantId());
	}
	
}
