package com.fanda.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fanda.entity.Role;

public interface RoleDAO extends JpaRepository<Role, Integer>{
	@Query(value="select * from role where role_name = ?1", nativeQuery = true)
	Optional<Role> getSellerRole(String seller);
}
