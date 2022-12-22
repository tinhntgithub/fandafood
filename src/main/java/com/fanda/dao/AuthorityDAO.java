package com.fanda.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fanda.entity.Authority;

public interface AuthorityDAO extends JpaRepository<Authority, Integer>{
    @Query(value="select * from authority where userid = ?1 and role_id = ?2", nativeQuery = true)
    Optional<Authority> findUserRoleByAccount(String username, String role);
}
