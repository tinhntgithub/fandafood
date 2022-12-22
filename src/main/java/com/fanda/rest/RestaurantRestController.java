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

import com.fanda.dao.RestaurantDAO;
import com.fanda.entity.Restaurant;
import com.fanda.service.RestaurantServ;
import com.fanda.serviceImpl.RestaurantServImpl;

@RestController
@RequestMapping("/rest/restaurant")
public class RestaurantRestController {
	@Autowired
	RestaurantServ rServ;
	@Autowired
	RestaurantDAO dao;
	@Autowired
	HttpServletRequest request;
	
	
	@GetMapping()
	public List<Restaurant> getAll() {
		return dao.findAll();
	}
	@GetMapping("{id}")
	public Optional<Restaurant> getById(@PathVariable("id") int id) {
		return dao.findById(id);
	}
	
	@GetMapping("/search/{name}")
	public List<Restaurant> getByName(@PathVariable("name") String id) {
		return dao.findkeys("%"+id+"%");
	}
	@PostMapping
	public Restaurant create(@RequestBody Restaurant o) {
		dao.saveAndFlush(o);

		return rServ.findById(o.getRestaurantId()).get();
	}
	
	@PutMapping
	public Restaurant update(@RequestBody Restaurant o) {
		return  dao.saveAndFlush(o);
	}
	

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") int id) {
		dao.deleteById(id);
	}
	
	//duyên đã update cái này
	@GetMapping("/myRestaurant")
	public Optional<Restaurant> getMyRestaurant() {
		
		return dao.findByUser(request.getRemoteUser());
	}
}
