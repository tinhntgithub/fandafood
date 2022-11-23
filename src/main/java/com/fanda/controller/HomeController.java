package com.fanda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/home/index")
	public String index() {
		return "home/home";
	}
	
	@RequestMapping("/home/trending")
	public String trending() {
		return "home/trending";
	}
}
