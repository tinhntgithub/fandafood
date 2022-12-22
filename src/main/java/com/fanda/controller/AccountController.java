package com.fanda.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fanda.dao.AccountDAO;
import com.fanda.dao.AuthorityDAO;
import com.fanda.dao.RoleDAO;
import com.fanda.email.EmailService;
import com.fanda.entity.Account;
import com.fanda.entity.Authority;
import com.fanda.entity.Role;
import com.fanda.service.ParamService;
import com.fanda.service.SessionService;

import net.bytebuddy.utility.RandomString;

@Controller
public class AccountController {
	@Autowired
	AccountDAO dao;
	@Autowired
	EmailService mailer;
	@Autowired
	SessionService session;
	@Autowired
	ParamService paramService;
	@Autowired
	AuthorityDAO authoritiesDao;
	@Autowired
	RoleDAO roleDao;
	@RequestMapping("/account/login")
	public String login() {

		return "/account/login";
	}

	@RequestMapping("/account/signup")
	public String signup() {
		return "/account/signup";
	}

	@RequestMapping("/account/otp")
	public String otp() {
		return "/account/verification";
	}

	@RequestMapping("/account/login/success")
	public String success(Model model) {

		return "redirect:/home/index";
	}

	@RequestMapping("/account/login/error")
	public String error(Model model) {
		model.addAttribute("message", "Đăng Nhập Không Thành Công");

		return "/account/login";
	}

	@RequestMapping("/account/logout/success")
	public String logout() {
		return "forward:/account/login";
	}

	@GetMapping("/account/forgot")
	public String forgot(Model model) {

		model.addAttribute("formEmail", "block");
		model.addAttribute("done", "none");
		model.addAttribute("error", "none");
		model.addAttribute("changePass", "none");
		model.addAttribute("hoanthanh", "none");

		return "/account/forgot_password";

	}

	@PostMapping("/account/forgot")
	public String test(Model model) {

		String token = RandomString.make(45);

		String email = paramService.getString("email", "");

		model.addAttribute("email", email);

		Account findAccount = dao.findbyEmail(email);
		try {
			if (findAccount != null) {

				findAccount.setTokenReset(token);
				dao.saveAndFlush(findAccount);

				model.addAttribute("formEmail", "none");
				model.addAttribute("done", "block");
				model.addAttribute("error", "none");
				model.addAttribute("changePass", "none");
				model.addAttribute("hoanthanh", "none");

				String resetLink = "http://localhost:8080/account/reset_password?token=" + token + "&email=" + email;

				mailer.Hihi(email, resetLink, "Thiết lập lại mật khẩu đăng nhập FandaFood");

			} else {
				System.out.println("Không tìm thấy tài khoản");
				model.addAttribute("error", "block");
				model.addAttribute("formEmail", "block");
				model.addAttribute("done", "none");
				model.addAttribute("changePass", "none");
				model.addAttribute("hoanthanh", "none");
			}
		} catch (Exception e) {
			System.out.println("Không tìm thấy tài khoản");
			model.addAttribute("error", "block");
			model.addAttribute("formEmail", "block");
			model.addAttribute("done", "none");
			model.addAttribute("changePass", "none");
			model.addAttribute("hoanthanh", "none");
		}

		return "/account/forgot_password";
	}

	@GetMapping("/account/reset_password")
	public String changePassword(@RequestParam(value = "token") String token,
			@RequestParam(value = "email") String email, Model model) {

		model.addAttribute("email", email);
		model.addAttribute("formEmail", "none");
		model.addAttribute("done", "none");
		model.addAttribute("token", token);
		model.addAttribute("error", "none");
		model.addAttribute("error2", "none");
		model.addAttribute("hoanthanh", "none");
		return "/account/forgot_password";
	}

	@PostMapping("/account/reset_password")
	public String changePassword2(Model model) {
		String email = paramService.getString("email", "");
		String token = paramService.getString("token", "");
		String password1 = paramService.getString("password1", "");
		String password2 = paramService.getString("password2", "");

		Account findAccount = dao.findbyToken(token);
		try {
			if (findAccount != null) {
				if (password2.equals(password1)) {
					findAccount.setPassword(password2);
					dao.saveAndFlush(findAccount);
					model.addAttribute("error", "none");
					model.addAttribute("error2", "none");
					model.addAttribute("hoanthanh", "block");
					model.addAttribute("changePass", "none");
				} else {
					System.out.println("no");
					model.addAttribute("error", "block");
					model.addAttribute("error2", "none");
					model.addAttribute("hoanthanh", "none");
				}
			} else {
				model.addAttribute("error", "none");
				model.addAttribute("error2", "block");
				model.addAttribute("hoanthanh", "none");
			}
		} catch (Exception e) {
			model.addAttribute("error", "none");
			model.addAttribute("error2", "block");
			model.addAttribute("hoanthanh", "none");
		}

		model.addAttribute("email", email);
		model.addAttribute("token", token);
		model.addAttribute("formEmail", "none");
		model.addAttribute("done", "none");
		return "/account/forgot_password";
	}

	@PostMapping("/account/signup")
	public String signup(Model model) {
		String username = paramService.getString("username", "");
		String email = paramService.getString("email", "");
		String password = paramService.getString("password", "");
		String repeatpassword = paramService.getString("repeatpassword", "");

		try {
			if (username.equals("")) {
				model.addAttribute("message", "Vui lòng điền tên đăng nhập!");
			} else {
			Optional<Account> account = dao.findById(username);
				if (account.isPresent()) {
					model.addAttribute("message", "Tên đăng nhập đã tồn tại!");
				}
				else {
					if (email.equals("")) {
						model.addAttribute("message", "Vui lòng điền email!");
					} else {
						if (password.equals("")) {
							model.addAttribute("message", "Vui lòng điền mật khẩu!");
					} else {
						System.out.println(password + repeatpassword);
							if (!repeatpassword.equals(password)) {
								model.addAttribute("message", "Mật khẩu không trùng khớp với nhau!");
							} else {
								Account account2 = new Account();
								account2.setUsername(username);
								account2.setEmail(email);
								account2.setPassword(password);
								account2.setActive(true);
								account2.setCreatedate(new Date());
								account2.setAvatar("noImage.jpg");
								Role role = roleDao.findById(2).get();
								Authority authority = new Authority();
								authority.setAccount(account2);
								authority.setRole(role);
								dao.saveAndFlush(account2);
								authoritiesDao.saveAndFlush(authority);
								return "redirect:/account/login";
							}
						}
					}
				}
			}
		} catch (Exception e) {
		}

		return "/account/signup";
	}

}
