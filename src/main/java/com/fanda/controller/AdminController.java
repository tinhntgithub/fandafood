package com.fanda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	@RequestMapping("/admin/index")
	public String adminIndex(Model model) {
		return "redirect:/admin/index.html#!/index";
	}
	@RequestMapping("/admin/restaurant/index")
	public String restaurantIndex(Model model) {
		return "redirect:/admin/index.html#!/restaurant/index";
	}
	@RequestMapping("/admin/header")
	public String header(Model model) {
		
		 
		return "admin/layout/layout";
	}
}
