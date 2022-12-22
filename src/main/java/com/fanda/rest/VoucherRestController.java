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
import com.fanda.dao.VoucherApplyDAO;
import com.fanda.dao.VoucherDAO;
import com.fanda.entity.Restaurant;
import com.fanda.entity.Voucher;
import com.fanda.entity.VoucherApply;
import com.fanda.service.VoucherServ;
import com.fanda.serviceImpl.VoucherServImpl;

@RestController
@RequestMapping("/rest/voucher")
public class VoucherRestController {
	@Autowired
	VoucherServ vServ;
	@Autowired
	VoucherDAO dao;
	@Autowired
	VoucherApplyDAO applyDAO;
	@Autowired
	RestaurantDAO daoRes;
	@Autowired
	HttpServletRequest request;
	
	
	
	@GetMapping()
	public List<Voucher> getAll() {
		return vServ.findAll();
	}
	
	@GetMapping("/apply")
	public List<VoucherApply> getAll_apply() {
		return applyDAO.findAll();
	}
	
	
	
	@GetMapping("{id}")
	public Optional<Voucher> getById(@PathVariable("id") String id) {
		return dao.findById(id);
	}
	@PostMapping
	public Voucher create(@RequestBody Voucher o) {
		Restaurant res = daoRes.findByUser(request.getRemoteUser()).get();
		o.setVoucherResId(res);
		return vServ.create(o);
	}
	
	@PutMapping("{id}")
	public Voucher update(@PathVariable("id") String id, @RequestBody Voucher o) {
		return vServ.update(o);
	}
	

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") String id) {
		dao.deleteById(id);
	}
	
	@GetMapping("/restaurant")
	public List<Voucher> getByRestaurant() {
		Restaurant res = daoRes.findByUser(request.getRemoteUser()).get();
		return res.getGetlistVoucher();
	}
}
