package com.fanda.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/menucate")
public class MenuCateRestController {
	@Autowired
	MenuCategoryService mcServ;
	
	
	@GetMapping()
	public List<MenuCategory> getAll() {
		return mcServ.findAll();
	}
	@GetMapping("{id}")
	public MenuCategory getById(@PathVariable("id") String id) {
		return mcServ.findById(id);
	}
	@PostMapping
	public MenuCategory create(@RequestBody MenuCategory mc) {
		return mcServ.create(mc);
	}
	
	@PutMapping("{id}")
	public MenuCategory update(@PathVariable("id") String id, @RequestBody MenuCategory mc) {
		return mcServ.update(mc);
	}
	

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") String id) {
		mcServ.delete(id);
	}
}
