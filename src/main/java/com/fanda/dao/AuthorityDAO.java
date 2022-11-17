package com.fanda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fanda.entity.Authority;

public interface AuthorityDAO extends JpaRepository<Authority, Integer>{
	@Query("select a from Authority a where a.account.id = ?1")
	Authority findAccByAuthority(String id);
	
	@Query(value = "select COUNT(*) from Authorities where Username = ?1 " , nativeQuery = true)
	Integer countAuthor(String username);
}
