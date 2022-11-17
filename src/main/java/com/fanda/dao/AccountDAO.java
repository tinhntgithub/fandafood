package com.fanda.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fanda.entity.Account;
import com.fanda.entity.Authority;

public interface AccountDAO extends JpaRepository<Account, String>{
	@Query("select a from Account a where a.username = ?1 and a.email = ?2")
	Account findForgot(String id , String email);
	
	@Query("select a from Account a where a.username = ?1")
	Account CheckID(String id);
	
	@Query(value =  "select * from accounts inner join authorities on Accounts.Username = Authorities.Username where Accounts.Username = ?1 and RoleId like 'Admin'" , nativeQuery =  true)
	Account CheckIDAdmin(String id);
	
	@Query("select DISTINCT ar.account from Authority ar where ar.role.id IN ('Admin','User') ")
	List<Account> getAdminAccounts();
	
	@Query("select DISTINCT a from Authority a where a.account IN ?1  ")
	List<Authority> getAuthorritiesAdmin(List<Account> accounts);
	
	@Query(value = "select COUNT(*) from accounts",nativeQuery = true)
	Integer CountUser();
}
