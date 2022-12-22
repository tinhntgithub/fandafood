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

import com.fanda.dao.MenuCategoryDAO;
import com.fanda.dao.RestaurantDAO;
import com.fanda.entity.Menu_cate;
import com.fanda.entity.Restaurant;
import com.fanda.service.MenuCateServ;
import com.fanda.serviceImpl.MenuCateServImpl;

@RestController
@RequestMapping("/rest/menucate")
public class MenuCateRestController {
	@Autowired
	MenuCateServ mcServ;
	@Autowired
	MenuCategoryDAO dao;
	@Autowired
	RestaurantDAO daoRes;
	@Autowired
	HttpServletRequest request;
	
	
	@GetMapping()
	public List<Menu_cate> getAll() {
	
		return dao.findAll();
	}
	@GetMapping("{id}")
	public Optional<Menu_cate> getById(@PathVariable("id") int id) {
		return mcServ.findById(id);
	}
	@PostMapping
	public Menu_cate create(@RequestBody Menu_cate mc) {
		Restaurant res = daoRes.findByUser(request.getRemoteUser()).get();
		mc.setRestaurantMenu(res);
		return mcServ.create(mc);
	}
	
	@PutMapping("{id}")
	public Menu_cate update(@PathVariable("id") String id, @RequestBody Menu_cate mc) {
		return mcServ.update(mc);
	}
	

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") int id) {
		mcServ.delete(id);
	}
	
	//duyên update đoạn này
	@GetMapping("retaurant")
	public List<Menu_cate> getByRestaurant() {
		
		Restaurant res = daoRes.findByUser(request.getRemoteUser()).get();
		return dao.timMenu(res.getRestaurantId());
	}
	
}
