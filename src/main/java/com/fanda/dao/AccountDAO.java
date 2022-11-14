package com.fanda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fanda.entity.Account;

public interface AccountDAO extends JpaRepository<Account, String>{

}
