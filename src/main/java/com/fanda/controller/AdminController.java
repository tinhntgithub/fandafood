package com.fanda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	// ---------- DÙNG CHO ADMIN
	@RequestMapping("/index")
	public String adminIndex(Model model) {
		return "redirect:/admin/index.html#!/index";
	}


	// ---------- DÙNG CHO CHỦ NHÀ HÀNG
	@RequestMapping("/restaurant/index")
	public String restaurantIndex(Model model) {
		return "redirect:/admin/index.html#!/restaurant/index";
	}
	
	// ---------- DÙNG CHO TÀI XẾ
}
