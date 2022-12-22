package com.fanda.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

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
	@Autowired
	ServletContext context;
	
	@PostMapping("/profile/update")
	public String updateproduct(Account account, Model model,@RequestParam("photo") MultipartFile photo) {
		System.out.println(photo.getOriginalFilename());
		account = accountDAO.findById(request.getRemoteUser()).get();
		String firstname = paramService.getString("firstname", "");
		String lastname = paramService.getString("lastname", "");
		String email = paramService.getString("email", "");
		String phone = paramService.getString("phone", "");
		Boolean gender = paramService.getBoolean("gender", false);
		if (firstname.equals("")) {
			model.addAttribute("message", "không được để trống thông tin!");
		}
		String anh = photo.getOriginalFilename();
		account.setUsername(account.getUsername());
		account.setPassword(account.getPassword());
		account.setFirstname(firstname);
		account.setLastname(lastname);
		account.setEmail(email);
		account.setPhone(phone);
		account.setGender(gender);
		account.setActive(true);
		account.setCreatedate(new Date());
		account.setAvatar(account.getAvatar());
		if (!photo.isEmpty()) {
		
			account.setAvatar(anh);
			try {
			
				
				File fileimage = paramService.save(photo, "/user");
				System.out.println(fileimage);
				if (fileimage == null) {
					account.setAvatar(account.getAvatar());
				} else {
					account.setAvatar(fileimage.getName());
				}
			} catch (IllegalStateException e) {
				
			} catch (MaxUploadSizeExceededException e) {
				// TODO: handle exception
			}
			catch (Exception e) {
				return "redirect:/home/profile";
			}
		}
		accountDAO.saveAndFlush(account);
		return "redirect:/home/profile";
	}
	@RequestMapping("/profile/changepass")
	public String change_pass(Account account, Model model) {
		account = accountDAO.findById(request.getRemoteUser()).get();
		model.addAttribute("account", account);
		return "account/change_password";
	}
	@PostMapping("/account/changepass")
	public String changepass(Account account, Model model) {
		account = accountDAO.findById(request.getRemoteUser()).get();
		String password = paramService.getString("password", "");
		String newpass = paramService.getString("newpass", "");
		String repeatpass = paramService.getString("repeatpass", "");
		if (password.equals(account.getPassword())) {
			if (newpass.equals(repeatpass)) {
				account.setPassword(newpass);
				accountDAO.saveAndFlush(account);
			}
			else {
				return "redirect:/profile/changepass";
			}			
		}
		else {
			return "redirect:/profile/changepass";
		}
		
			model.addAttribute("account", account);		
		return "redirect:/home/profile";
	}
}
