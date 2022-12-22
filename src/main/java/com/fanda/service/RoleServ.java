package com.fanda.service;

import java.util.List;
import java.util.Optional;


import com.fanda.entity.Role;

public interface RoleServ {
	public List<Role> findAll();
	public Optional<Role> findById(int id);
	public Role create(Role Role);
	public Role update (Role Role);	
	public void delete(int Role);
}
