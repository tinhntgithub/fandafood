package com.fanda.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fanda.dao.RestaurantDAO;
import com.fanda.entity.Restaurant;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	RestaurantDAO dao;
	// ---------- DÙNG CHO ADMIN
	@RequestMapping("/index")
	public String adminIndex(Model model) {
		return "redirect:/admin/index.html#!/manager/account";
	}


	// ---------- DÙNG CHO CHỦ NHÀ HÀNG
	@RequestMapping("/restaurant/index")
	public String restaurantIndex(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
<<<<<<< HEAD
		System.out.println(principal);
=======
>>>>>>> c7a68e5d1e6a4b635a36378809b99ed8469693ea
		String username;
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
			
		} else {
			username = principal.toString();
			
		}
		if(username == "anonymousUser") {//chưa đăng nhập
			System.out.println("Chưa đăng nhập sao mà quản lý được");
			return "/account/login";
		}else {
			Optional<Restaurant> r = dao.findByUser(username);
			if(r.isPresent()) {
				System.out.println("Đăng nhập rồi và đã có nhà hàng");
				return "redirect:/admin/index.html#!/restaurant/index";
			}else {
				System.out.println("Chưa có nhà hàng");
				
				
				System.out.println(username);
				return "redirect:/merchant/register.html";
			}
			
		}
		
	}
	}
	
	// ---------- DÙNG CHO TÀI XẾ

