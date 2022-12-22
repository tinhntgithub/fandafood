package com.fanda.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fanda.dao.AccountDAO;
import com.fanda.dao.FavoriteDAO;
import com.fanda.dao.FoodDAO;
import com.fanda.entity.Account;
import com.fanda.entity.Favorite;
import com.fanda.entity.Food;

@Controller
public class FavoriteController {
	@Autowired
	FavoriteDAO favoriteDAO;
	@Autowired
	HttpServletRequest request;
	@Autowired
	FoodDAO foodDAO;
	@Autowired
	AccountDAO accountDAO;

	@GetMapping("/favorites/like/{id}")
	public String like(Favorite favorite, Model model, @PathVariable("id") int id) {
		Account account = accountDAO.findById(request.getRemoteUser()).get();
		
			Food food = foodDAO.findById(id).get();

			favorite.setFood(food);
			favorite.setAccount(account);
			favoriteDAO.saveAndFlush(favorite);
		
		return "redirect:/home/index";
	}

	@GetMapping("/favorites/dislike/{id}")
	public String dislike(Favorite favorite, Model model, @PathVariable("id") int id) {
		favorite = favoriteDAO.findById(id).get();
		favoriteDAO.deleteById(favorite.getFavoriteId());
		List<Favorite> favorite1 = favoriteDAO.favorites(request.getRemoteUser());
		model.addAttribute("favorite", favorite1);
		System.out.println(request.getRemoteUser());
		return "redirect:/home/favorites";
	}
}
