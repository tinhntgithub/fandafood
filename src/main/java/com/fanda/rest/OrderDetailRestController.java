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

import com.fanda.dao.OrderDetailDAO;
import com.fanda.entity.Order_detail;
import com.fanda.service.OrderDetailServ;
import com.fanda.serviceImpl.OderDetailServImpl;

@RestController
@RequestMapping("/rest/odetail")
public class OrderDetailRestController {
	@Autowired
	OrderDetailServ odServ;
	@Autowired
	OrderDetailDAO dao ;
	
	
	@GetMapping()
	public List<Order_detail> getAll() {
		
		return dao.findAll();
	}
	@GetMapping("{id}")
	public List<Order_detail> getById(@PathVariable("id") int id) {
		return dao.findDetails(id);
	}
	@PostMapping
	public Order_detail create(@RequestBody Order_detail o) {
		return odServ.create(o);
	}
	
	@PutMapping("{id}")
	public Order_detail update(@PathVariable("id") String id, @RequestBody Order_detail o) {
		return odServ.update(o);
	}
	

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") int id) {
		odServ.delete(id);
	}
}
