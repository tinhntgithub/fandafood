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
	@RequestMapping("/home/terms")
	public String terms() {
		return "home/terms";
	}
	
	@RequestMapping("/home/success")
	public String success() {
		return "home/successful";
	}

	@RequestMapping("/home/search")
	public String search() {
		return "home/search";
	}
	@RequestMapping("/home/restaurant")
	public String restaurant() {
		return "home/restaurant";
	}
	@RequestMapping("/home/profile")
	public String profile() {
		return "home/profile";
	}
	@RequestMapping("/home/privacy")
	public String privacy() {
		return "home/privacy";
	}
	@RequestMapping("/home/offers")
	public String offers() {
		return "home/offers";
	}
	@RequestMapping("/home/notfound")
	public String notfound() {
		return "home/not_found";
	}
	@RequestMapping("/home/myorder")
	public String myorder() {
		return "home/my_order";
	}
}
