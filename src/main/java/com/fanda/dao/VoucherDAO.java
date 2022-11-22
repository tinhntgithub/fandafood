package com.fanda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fanda.entity.Voucher;

public interface VoucherDAO extends JpaRepository<Voucher, Integer>{

}
