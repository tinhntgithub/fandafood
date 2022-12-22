package com.fanda;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fanda.security.UserService;





@Configuration
@EnableWebSecurity
public class AuthSecurity extends WebSecurityConfigurerAdapter {

	//dùng để mã hóa mật khẩu
	@Autowired
	BCryptPasswordEncoder ca;
	@Autowired
	HttpServletRequest request;
	
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	UserService service;
	// thiết lập mật khẩu và user name , role , quản lý người đùng đăng nhập
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(service);
		}
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable().cors().disable(); // tắt form login cổ điển 
			
			
			
			http.authorizeRequests().antMatchers("/home/profile" ,"/home/checkout","/home/myorder","/home/favorites"
					)
			.hasAnyRole("ADMIN", "USER","SELLER")
			.antMatchers("/home/checkout").authenticated().antMatchers("/admin/***").hasAnyRole("ADMIN","SELLER")
			.anyRequest().permitAll();
			
			
			
			http.exceptionHandling()
			.accessDeniedPage("/account/login");
			
			
			http.formLogin().loginPage("/account/login").loginProcessingUrl("/form/login")
			.defaultSuccessUrl("/account/login/success",false).failureUrl("/account/login/error")
			.usernameParameter("username").passwordParameter("password");
			http.rememberMe().rememberMeParameter("remember");// ghi nhớ tài khoảng
			
			
			http.logout().logoutUrl("/account/logout").logoutSuccessUrl("/account/logout/success");
			
		}
	
	
		@Override
		public void configure(WebSecurity web) throws Exception {
			web.ignoring().antMatchers(HttpMethod.OPTIONS,"/**");
		}
	
	
}
