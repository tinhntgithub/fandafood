package com.fanda.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fanda.entity.Voucher;

public interface VoucherDAO extends JpaRepository<Voucher, String>{
	
}
