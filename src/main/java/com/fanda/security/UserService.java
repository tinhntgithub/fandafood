package com.fanda.security;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.User;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

import com.fanda.dao.AccountDAO;
import com.fanda.entity.Account;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	AccountDAO accountDao;

	@Autowired
	BCryptPasswordEncoder pc;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			Account account = accountDao.findById(username).get();
			
			String password = account.getPassword();
			String [] role = account.getAuthorities().stream().map(au -> au.getRole().getRoleName())
					.collect(Collectors.toList()).toArray(new String[0]);
		
			return User.withUsername(username).password(pc.encode(password)).roles(role).build();

		} catch (Exception e) {

			System.err.println("Đăng nhập k thành công" + e);

			throw new UsernameNotFoundException(username + "Not Found");
		}

	}

}
