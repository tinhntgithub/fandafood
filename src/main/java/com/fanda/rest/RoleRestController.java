package com.fanda.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rest/role")
@RestController
public class RoleRestController {
	@Autowired
	RoleService rServ;
	
	
	@GetMapping()
	public List<Role> getAll() {
		return rServ.findAll();
	}
	@GetMapping("{id}")
	public Role getById(@PathVariable("id") String id) {
		return rServ.findById(id);
	}
	@PostMapping
	public Role create(@RequestBody Role o) {
		return rServ.create(o);
	}
	
	@PutMapping("{id}")
	public Role update(@PathVariable("id") String id, @RequestBody Role o) {
		return rServ.update(o);
	}
	

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") String id) {
		rServ.delete(id);
}
