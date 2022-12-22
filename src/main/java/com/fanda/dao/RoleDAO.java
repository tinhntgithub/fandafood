package com.fanda.dao;

<<<<<<< HEAD
import java.util.List;
=======
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
>>>>>>> 0da8e6354590aa75b65d971f44ab9387520b3144

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fanda.entity.Authority;
import com.fanda.entity.Role;

public interface RoleDAO extends JpaRepository<Role, Integer>{
<<<<<<< HEAD
	@Query(value="select * from fandafood.authority a where a.role_id = 1" , nativeQuery=true)
	List<Authority> findAdminByRoleIdAuthorities();
=======
	@Query(value="select * from role where role_name = ?1", nativeQuery = true)
	Optional<Role> getSellerRole(String seller);
>>>>>>> 0da8e6354590aa75b65d971f44ab9387520b3144
}
