package com.fanda.rest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fanda.dao.AccountDAO;
import com.fanda.dao.CartDAO;
import com.fanda.dao.DeliveryAddressDAO;
import com.fanda.dao.FoodDAO;
import com.fanda.dao.OrderDAO;
import com.fanda.dao.OrderDetailDAO;
import com.fanda.dao.RestaurantDAO;
import com.fanda.dao.VoucherDAO;
import com.fanda.entity.Account;
import com.fanda.entity.Delivery_address;
import com.fanda.entity.Order;
import com.fanda.entity.Order_detail;
import com.fanda.entity.Restaurant;
import com.fanda.entity.Voucher;
import com.fanda.service.AccountServ;
import com.fanda.service.OrderServ;
import com.fanda.serviceImpl.OrderServImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/rest/order")
public class OrderRestController {
	@Autowired
	OrderServ oServ;
	@Autowired
	OrderDAO dao;
	@Autowired
	OrderDetailDAO orderDetailDAO;
	@Autowired
	FoodDAO foodDAO;
	@Autowired
	AccountDAO account_dao;
	@Autowired
	HttpServletRequest request;
	@Autowired
	AccountServ ac;
	@Autowired
	DeliveryAddressDAO addressDAO ;
	@Autowired
	VoucherDAO voucherdao;
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	RestaurantDAO daoRes;
	

	@GetMapping()
	public List<Order> getAll() {
		return dao.findAll();
	}
	@GetMapping("/review/{id}")
	public void update_status(@PathVariable("id") int id) {
		Order order = dao.findById(id).get();
		order.setStatus(4);
		dao.saveAndFlush(order);
	}
	
	@GetMapping("/myorder")
	public List<Order> getAllordersByUsser(@RequestParam("status")Integer trangthai ) {
			
		return dao.listTrueOrders(request.getRemoteUser(),trangthai);
	}

	@GetMapping("{id}")
	public Optional<Order> getById(@PathVariable("id") int id) {
		return oServ.findById(id);
	}

	@PostMapping
	public ResponseEntity<Object> create(@RequestBody JsonNode orderData) {
		System.out.println(orderData);
		try {
			
		
		Account account = account_dao.findById(request.getRemoteUser()).get();
		Delivery_address address = addressDAO.findAddressTrue(request.getRemoteUser()).get();
		ObjectMapper objectMapper = new ObjectMapper();
		Order order = objectMapper.convertValue(orderData, Order.class);
		
		Double sumDouble = cartDAO.sumCarts(request.getRemoteUser(),order.getRestaurant().getRestaurantId());
		System.out.println(sumDouble);

		if (order.getVoucher().getId() != null) {
			Voucher voucher = voucherdao.findById(order.getVoucher().getId()).get();
			if (sumDouble < voucher.getMinimum_order()) {
				return ResponseEntity.notFound().build();
			}
			order.setVoucher(voucher);
		}else {
			order.setVoucher(null);
		}
		
		order.setAccount(account);
		order.setAddress(address);
		
		dao.saveAndFlush(order);

		TypeReference<List<Order_detail>> type = new TypeReference<List<Order_detail>>() {
		};
		List<Order_detail> details = objectMapper.convertValue(orderData.get("orderDetails"), type).stream().peek(d -> {
			d.setOrder(order);
			
		}).collect(Collectors.toList());
		orderDetailDAO.saveAllAndFlush(details);
		
		return ResponseEntity.noContent().build();

	
		
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		

	}
	

	@PutMapping("{id}")
	public Order update(@PathVariable("id") String id, @RequestBody Order o) {
		return oServ.update(o);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") int id) {
		oServ.delete(id);
	}
	
	 // duyên mới cập nhật cái này - - - - -
	
	@GetMapping("/restaurant/{status}")
	public List<Order> getListOderbyRestaurantAndStatus(@PathVariable("status") int status) {
		Restaurant res = daoRes.findByUser(request.getRemoteUser()).get();
		return dao.getListOderbyRestaurantAndStatus(res.getRestaurantId(),status);
	}
	
	@GetMapping("/orderDetail/{id}")
	public List<Order_detail> getListOderDetailByOder(@PathVariable("id") Integer id) {
		Order o = dao.findById(id).get();
		return o.getOrderDetails();
	}
	
	
}
