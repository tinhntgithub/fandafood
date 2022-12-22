package com.fanda.rest;

import java.util.List;

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
import com.fanda.dao.RestaurantDAO;
import com.fanda.dao.ReviewDAO;
import com.fanda.entity.Account;
import com.fanda.entity.Restaurant;
import com.fanda.entity.Review;
import com.fanda.service.ReviewServ;

@RestController
@RequestMapping("/rest/review")
public class ReviewRestController {
	@Autowired
	ReviewServ rServ;
	@Autowired
	ReviewDAO dao;
	@Autowired
	AccountDAO accountDAO;
	@Autowired
	RestaurantDAO restaurantDAO;
	@Autowired
	HttpServletRequest request;

	
	
	@GetMapping()
	public List<Review> getAll() {
		return dao.findAll();
	}
	@GetMapping("{id}")
	public List<Review> getById(@PathVariable("id") int id) {
		return dao.timDanhGiaNhaHang(id);
	}
	@PostMapping
	public Review create(@RequestBody Review o) {
		Account account = accountDAO.findById(request.getRemoteUser()).get();
		Restaurant restaurant = restaurantDAO.findById(o.getFood().getMenu_cate().getRestaurantMenu().getRestaurantId()).get();
		
		o.setAccount(account);
		o.setRestaurant(restaurant);
		o.setFood(o.getFood());
		return dao.saveAndFlush(o);
			
	}
	
	@PutMapping("{id}")
	public Review update(@PathVariable("id") String id, @RequestBody Review o) {
		return rServ.update(o);
	}
	

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") int id) {
		rServ.delete(id);
	}
	
	// duyên update cái này
	@GetMapping("/restaurant")
	public List<Review> getByRes() {
		Restaurant res = restaurantDAO.findByUser(request.getRemoteUser()).get();
		return dao.timDanhGiaNhaHang(res.getRestaurantId());
	}
	
	@GetMapping("/restaurant/totalReview")
	public Object[] getTotalByRes() {
		Restaurant res = restaurantDAO.findByUser(request.getRemoteUser()).get();
		return dao.findTatolReview(res.getRestaurantId());
	}
	
}
