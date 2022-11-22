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

import com.fanda.entity.Prioritized;
import com.fanda.service.PrioritizedService;

@RestController
@RequestMapping("/rest/prior")
public class PriorRestController {
	@Autowired
	PrioritizedService pServ;
	
	
	@GetMapping()
	public List<Prioritized> getAll() {
		return pServ.findAll();
	}
	@GetMapping("{id}")
	public Optional<Prioritized> getById(@PathVariable("id") int id) {
		return pServ.findById(id);
	}
	@PostMapping
	public Prioritized create(@RequestBody Prioritized o) {
		return pServ.create(o);
	}
	
	@PutMapping("{id}")
	public Prioritized update(@PathVariable("id") String id, @RequestBody Prioritized o) {
		return pServ.update(o);
	}
	

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") int id) {
		pServ.delete(id);
	}
}
