package com.fanda.rest;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fanda.dao.AccountDAO;
import com.fanda.dao.DeliveryAddressDAO;
import com.fanda.entity.Account;
import com.fanda.entity.Delivery_address;
import com.fanda.service.DeliAddServ;
import com.fanda.serviceImpl.DeliAddServImpl;








@RestController
@RequestMapping("/rest/address")
public class DeliveryAddRestController {
	@Autowired
	 DeliAddServ deliAddServ;
	@Autowired
	DeliveryAddressDAO dao ;
	@Autowired
	AccountDAO accountDao;
	@Autowired
	HttpServletRequest request;
	
	
	@GetMapping()
	public List<Delivery_address> getAll() {
		return dao.findAll();
	}
	
	
	@GetMapping("/address_true")
	public Optional<Delivery_address> getAddress_true() {
		return dao.findAddressTrue(request.getRemoteUser());
	}
	
	
	
	@GetMapping("{id}")
	public Optional<Delivery_address> getById(@PathVariable("id") int id) {
		return deliAddServ.findById(id);
	}
	@GetMapping("/user")
	public List<Delivery_address> getAddress_user() {
		return dao.findAddresses(request.getRemoteUser());
	}
	
	@PostMapping
	public Delivery_address create(@RequestBody Delivery_address deli) {
		//Delivery_address(id=3, phone=0987654321, address=Cần thơ, Active=null, account=null, orders=null)
		System.out.println(deli);
		Optional<Delivery_address> add = dao.findAddressTrue(request.getRemoteUser());
		if (add.isPresent()) {
			Optional<Account> account = accountDao.findById(request.getRemoteUser());
			
			deli.setAccount(account.get());
			deli.setActive(false);
			dao.saveAndFlush(deli);
			
		}else {
			Optional<Account> account = accountDao.findById(request.getRemoteUser());
			
			deli.setAccount(account.get());
			deli.setActive(true);
			dao.saveAndFlush(deli);
		}
		return deli;
		
		
	}
	
	
	
	@PutMapping("{id}")
	public Delivery_address update(@PathVariable("id") int id, @RequestBody Delivery_address deli) {
		Optional<Delivery_address> optional = dao.findById(id);
		if (deli.getCity() == "" && deli.getDistricts() == "" && deli.getWards() == "") {
			optional.get().setName(deli.getName());
			optional.get().setCity(optional.get().getCity());
			optional.get().setDistricts(optional.get().getDistricts());
			optional.get().setWards(optional.get().getWards());
			optional.get().setPhone(deli.getPhone());
			dao.saveAndFlush(optional.get());
		}else {
			optional.get().setName(deli.getName());
			optional.get().setCity(deli.getCity());
			optional.get().setDistricts(deli.getDistricts());
			optional.get().setWards(deli.getWards());
			optional.get().setPhone(deli.getPhone());
			dao.saveAndFlush(optional.get());
		}
		

		
		return optional.get();
		
	}
	
	@GetMapping("/choose/{id}")
	public Delivery_address choose(@PathVariable("id") int id) {

	
		Optional<Delivery_address> list = dao.findById(id);
		Optional<Delivery_address> aList = dao.findAddressTrue(request.getRemoteUser());
		if (list.get().getActive() == false) { // nếu là false thì set nó thành true
			list.get().setActive(true);
			aList.get().setActive(false);// set cái true hiện tại thành false
			dao.saveAndFlush(list.get());
		}
		return list.get();
		
	}
	
	
	

	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id) {
		try {
			Optional<Delivery_address> aList = dao.findAddressTrue_address(id,request.getRemoteUser());
			
			if(aList.isPresent()) {
				
				return ResponseEntity.status(400).body("Bạn không thể xóa địa chỉ được sử dụng");
			}else {
				dao.deleteById(id);
				return ResponseEntity.noContent().build();
			}
				
			
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Bạn không thể xóa địa chỉ này");
		}
		
	}
}
