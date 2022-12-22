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

import com.fanda.entity.Picture;
import com.fanda.service.PictureServ;
import com.fanda.serviceImpl.PictureServImpl;

@RestController
@RequestMapping("/rest/pic")
public class PictureRestController {
	@Autowired
	PictureServ pServ;
	
	
	@GetMapping()
	public List<Picture> getAll() {
		return pServ.findAll();
	}
	@GetMapping("{id}")
	public Optional<Picture> getById(@PathVariable("id") int id) {
		return pServ.findById(id);
	}
	@PostMapping
	public Picture create(@RequestBody Picture o) {
		return pServ.create(o);
	}
	
	@PutMapping("{id}")
	public Picture update(@PathVariable("id") String id, @RequestBody Picture o) {
		return pServ.update(o);
	}
	

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") int id) {
		pServ.delete(id);
	}
}
