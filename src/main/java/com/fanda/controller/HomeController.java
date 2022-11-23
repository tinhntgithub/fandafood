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
	
	@RequestMapping("/home/checkout")
	public String checkout() {
		return "home/checkout";
	}
	
	@RequestMapping("/home/coming_soon")
	public String comming_soon() {
		return "home/coming-soon";
	}
	
	@RequestMapping("/home/contact_us")
	public String contact_us() {
		return "home/contact-us";
	}
	
	@RequestMapping("/home/faq")
	public String faq() {
		return "home/faq";
	}
	
	@RequestMapping("/home/favorites")
	public String favorites() {
		return "home/favorites";
	}
	
	@RequestMapping("/home/location")
	public String location() {
		return "home/location";
	}
	
	@RequestMapping("/home/maintencen")
	public String maintencen() {
		return "home/maintence";
	}
	
	@RequestMapping("/home/map")
	public String map() {
		return "home/map";
	}
	
	@RequestMapping("/home/most_popular")
	public String most_popular() {
		return "home/most_popular";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
