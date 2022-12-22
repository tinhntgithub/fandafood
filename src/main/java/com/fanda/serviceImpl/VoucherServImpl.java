package com.fanda.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fanda.dao.VoucherDAO;
import com.fanda.entity.Voucher;
import com.fanda.service.VoucherServ;
@Service
public class VoucherServImpl implements VoucherServ {
	@Autowired
	VoucherDAO dao;
	@Override
	public List<Voucher> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}



	@Override
	public Voucher create(Voucher Voucher) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(Voucher);
	}

	@Override
	public Voucher update(Voucher Voucher) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(Voucher);
	}



	@Override
	public Optional<Voucher> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void delete(String Voucher) {
		// TODO Auto-generated method stub
		
	}



}
