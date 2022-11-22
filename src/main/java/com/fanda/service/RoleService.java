package com.fanda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.fanda.dao.RoleDAO;
import com.fanda.entity.Role;
import com.fanda.interface_.RoleInterface;

public class RoleService implements RoleInterface{
	@Autowired
	RoleDAO dao;
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<Role> findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public Role create(Role Role) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(Role);
	}

	@Override
	public Role update(Role Role) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(Role);
	}

	@Override
	public void delete(int Role) {
		// TODO Auto-generated method stub
		dao.deleteById(Role);
	}

}
