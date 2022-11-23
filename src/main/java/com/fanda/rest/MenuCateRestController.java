package com.fanda.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fanda.entity.Menu_cate;
import com.fanda.service.MenuCateServ;
import com.fanda.serviceImpl.MenuCateServImpl;

@RestController
@RequestMapping("/rest/menucate")
public class MenuCateRestController {
	@Autowired
	MenuCateServ mcServ;
	
	
	@GetMapping()
	public List<Menu_cate> getAll() {
		return mcServ.findAll();
	}
	@GetMapping("{id}")
	public Optional<Menu_cate> getById(@PathVariable("id") int id) {
		return mcServ.findById(id);
	}
	@PostMapping
	public Menu_cate create(@RequestBody Menu_cate mc) {
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
}
