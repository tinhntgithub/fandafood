package com.fanda.rest;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.fanda.dao.CartDAO;
import com.fanda.dao.RestaurantDAO;
import com.fanda.entity.Account;
import com.fanda.entity.Cart;
import com.fanda.entity.Food;
import com.fanda.entity.Restaurant;
import com.fanda.service.CartServ;
import com.fanda.serviceImpl.CartServImpl;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;



@RestController
@RequestMapping("/rest/cart")
public class CartRestController {
	@Autowired
	CartServ cartServ;
	@Autowired
	CartDAO dao;
	@Autowired
	HttpServletRequest request;
	@Autowired
	AccountDAO acc_dao;
	@Autowired
	RestaurantDAO ressRestaurantDAO;
	@GetMapping()
	public List<Cart> getAllCart(Optional<Account> accounts) {
			if(request.getRemoteUser() != null) {
				accounts = acc_dao.findById(request.getRemoteUser());
			}
		
		return dao.listCart(accounts.get().getUsername());
	}
	
	@GetMapping("/restaraunt/{id}")
	public List<Cart> getAllCart_restaraunt(@PathVariable("id") int id ,Optional<Account> accounts) {
			if(request.getRemoteUser() != null) {
				accounts = acc_dao.findById(request.getRemoteUser());
			}
		
		return dao.AccountCart_Restaraunt(accounts.get().getUsername(),id);
	}
	
	

	@GetMapping("{id}")
	public Optional<Cart> getById(@PathVariable("id") int id) {
		return cartServ.findById(id);
	}

	@PostMapping
	public ResponseEntity<Object> create(
			/* @RequestBody List<Food> node */
			@RequestBody Cart cart) throws IOException {

		try {
			
		
				Account account = acc_dao.findById(request.getRemoteUser()).get();
			//	Restaurant restaurant = ressRestaurantDAO.findById(cart.getRestaurant().getRestaurantId()).get();
				Optional<Cart> op = dao.listCart(account.getUsername(), cart.getFood().getFood_id() , cart.getRestaurant().getRestaurantId());
				
				if (op.isEmpty()) {
					cart.setAccount(account);
					cart.setFood(cart.getFood());
					cart.setQty(cart.getQty());
					//cart.setRestaurant(restaurant);
					dao.saveAndFlush(cart);
					
				}else {
					
					op.get().setQty(cart.getQty()+op.get().getQty());
					dao.saveAndFlush(op.get());
				
				}
				return ResponseEntity.noContent().build();
				
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Lỗi server" + e);
			return ResponseEntity.notFound().build();
		}
		
		
	}

	@PutMapping("{id}")
	public Cart update(@PathVariable("id") int id, @RequestBody Cart cart) {
		Optional<Cart> optional = dao.findById(id);
		optional.get().setQty(cart.getQty());
			
		dao.saveAndFlush(optional.get());
		
			
			return dao.findById(id).get();
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") int id) {
		dao.deleteById(id);
	}
	@DeleteMapping("/clearCart/{username}")
	public void delete(@PathVariable("username") String username) {
		List<Cart> op = dao.AccountCart(username);
			for (Cart cart : op) {
				dao.deleteById(cart.getId());
			}
	}
	
	@GetMapping("/sum/{id}")
	public Double sumCart(@PathVariable("id") Integer id) {
		return dao.sumCarts(request.getRemoteUser(),id);
	}
}
