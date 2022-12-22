package com.fanda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MerchantCtrl {
	

	@RequestMapping("/merchant-register")
	public String index() {
		
		return "redirect:/merchant/register.html";
	}
}