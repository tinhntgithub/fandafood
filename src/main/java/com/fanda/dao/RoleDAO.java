package com.fanda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fanda.entity.Role;

public interface RoleDAO extends JpaRepository<Role, Integer>{

}
