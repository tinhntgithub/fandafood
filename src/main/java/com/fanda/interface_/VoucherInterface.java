package com.fanda.interface_;

import java.util.List;
import java.util.Optional;

import com.fanda.entity.Voucher;


public interface VoucherInterface {
	public List<Voucher> findAll();
	public Optional<Voucher> findById(int id);
	public Voucher create(Voucher Voucher);
	public Voucher update (Voucher Voucher);	
	public void delete(int Voucher);
}