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
		return "home/not-found";
	}
	@RequestMapping("/home/myorder")
	public String myorder() {
		return "home/my_order";
	}

}
