package com.fanda.controller;

<<<<<<< HEAD
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
=======
>>>>>>> 5acf283aa88d56a081c4c1d8e3a03434220921c9

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestMapping;

import com.fanda.dao.AccountDAO;
import com.fanda.entity.Account;

@Controller
public class HomeController {
=======
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fanda.dao.FoodDAO;
import com.fanda.dao.MenuCategoryDAO;
import com.fanda.dao.RestaurantDAO;
import com.fanda.entity.Food;
import com.fanda.entity.Menu_cate;
import com.fanda.entity.Restaurant;




@Controller
public class HomeController {
	
	@Autowired
	FoodDAO dao ;

>>>>>>> 5acf283aa88d56a081c4c1d8e3a03434220921c9

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
<<<<<<< HEAD

=======
	
	@Autowired
	MenuCategoryDAO menudao ;
	@Autowired
	RestaurantDAO resDao;
	
	@RequestMapping("/home/food/detail/{id}")
	public String detail(@PathVariable("id") Integer id , Food food ,Menu_cate menu,Restaurant res, Model model) {
			food = dao.findById(id).get();
			menu = menudao.findById(id).get();
			int id_rest = food.getMenu_cate().getRestaurant_id();
			
			
			
			model.addAttribute("id_rest",id_rest);
			model.addAttribute("food", food);
			
		return "/home/food_detail";
	}
	
>>>>>>> 5acf283aa88d56a081c4c1d8e3a03434220921c9
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
<<<<<<< HEAD

	@Autowired
	HttpServletRequest request;
	@Autowired
	AccountDAO accountDAO;

	@RequestMapping("/home/profile")
	public String profile(Account account, Model model) {
		account = accountDAO.findById(request.getRemoteUser()).get();
		model.addAttribute("account", account);		
=======
	
	@RequestMapping("/home/restaurant/{id}")
	public String restaurant_detail(@PathVariable("id") Integer id , Restaurant restaurant , Model model) {
		restaurant = resDao.findById(id).get();
		model.addAttribute("restaurant", restaurant);
		
		return "home/restaurant";
	}
	
	
	@RequestMapping("/home/profile")
	public String profile() {
		
>>>>>>> 5acf283aa88d56a081c4c1d8e3a03434220921c9
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
