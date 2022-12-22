package com.fanda.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fanda.dao.RoleDAO;
import com.fanda.entity.Authority;

@RequestMapping("/rest/author")
@RestController
public class RestAuthorityController {
	@Autowired
	RoleDAO dao;
	
	
	@GetMapping("/authorAdmin")
	public List<Authority> getAccounts(){
	
		return dao.findAdminByRoleIdAuthorities();
}
}
