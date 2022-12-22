package com.fanda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fanda.entity.Voucher;
import com.fanda.entity.VoucherApply;

public interface VoucherApplyDAO extends JpaRepository<VoucherApply, Integer>{

}
