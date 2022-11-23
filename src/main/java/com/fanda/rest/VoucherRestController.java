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

import com.fanda.entity.Voucher;
import com.fanda.service.VoucherServ;
import com.fanda.serviceImpl.VoucherServImpl;

@RestController
@RequestMapping("/rest/voucher")
public class VoucherRestController {
	@Autowired
	VoucherServ vServ;
	
	
	@GetMapping()
	public List<Voucher> getAll() {
		return vServ.findAll();
	}
	@GetMapping("{id}")
	public Optional<Voucher> getById(@PathVariable("id") int id) {
		return vServ.findById(id);
	}
	@PostMapping
	public Voucher create(@RequestBody Voucher o) {
		return vServ.create(o);
	}
	
	@PutMapping("{id}")
	public Voucher update(@PathVariable("id") String id, @RequestBody Voucher o) {
		return vServ.update(o);
	}
	

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") int id) {
		vServ.delete(id);
	}
}
