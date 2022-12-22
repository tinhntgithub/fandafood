package com.fanda.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fanda.entity.Account;
import com.fanda.entity.Authority;

public interface AccountDAO extends JpaRepository<Account, String>{
	@Query(value ="select * from fandafood.account where email = ?1", nativeQuery = true)
	Account findbyEmail(String email);
	
	@Query(value ="select * from fandafood.account where reset_password_token = ?1", nativeQuery = true)
	Account findbyToken(String token);
	
	
	@Query(value =  "select * from account inner join authority on account.username = authority.userid where account.username = ?1 and authority.role_id = 1" , nativeQuery =  true)
	Account CheckIDAdmin(String id);
	
	@Query("select DISTINCT ar.account from Authority ar where ar.role.roleName IN ('ADMIN','USER') ")
	List<Account> getAdminAccounts();
	
	@Query("select DISTINCT a from Authority a where a.account IN ?1  ")
	List<Authority> getAuthorritiesAdmin(List<Account> accounts);
}
