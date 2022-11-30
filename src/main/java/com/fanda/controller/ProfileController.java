package com.fanda.controller;

import java.net.http.HttpClient.Redirect;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.fanda.dao.AccountDAO;
import com.fanda.entity.Account;
import com.fanda.service.ParamService;
@Controller
public class ProfileController {
	@Autowired
	HttpServletRequest request;
	@Autowired
	AccountDAO accountDAO;
	@Autowired
	ParamService paramService;
	@PostMapping("/profile/update")
	public String updateproduct(Account account, Model model) {
		account = accountDAO.findById(request.getRemoteUser()).get();
		String firstname = paramService.getString("firstname", "");
		String lastname = paramService.getString("lastname", "");
		String email = paramService.getString("email", "");
		String phonenumber = paramService.getString("phonenumber", "");
		Boolean gender = paramService.getBoolean("gender", false);
		account.setUsername(account.getUsername());
		account.setPassword(account.getPassword());
		account.setFirstname(firstname);
		account.setLastname(lastname);
		account.setEmail(email);
		account.setPhonenumber(phonenumber);
		account.setGender(gender);
		account.setActive(true);
		account.setCreatedate(new Date());
		accountDAO.saveAndFlush(account);
		System.out.println(gender);
		return "/home/profile";
	}
}
