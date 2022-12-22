package com.fanda.service;

import java.util.List;
import java.util.Optional;

import com.fanda.entity.Voucher;


public interface VoucherServ {
	public List<Voucher> findAll();
	public Optional<Voucher> findById(String id);
	public Voucher create(Voucher Voucher);
	public Voucher update (Voucher Voucher);	
	public void delete(String Voucher);
}
