package com.fanda.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fanda.dao.PremiumBundleDAO;
import com.fanda.entity.premiumBundle;
import com.fanda.service.PremiumBundleServ;

@Service
public class PremiumBundleServImpl implements PremiumBundleServ{

	@Autowired
	PremiumBundleDAO dao;
	@Override
	public List<premiumBundle> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<premiumBundle> findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public premiumBundle create(premiumBundle premiumBundle) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(premiumBundle);
	}

	@Override
	public premiumBundle update(premiumBundle premiumBundle) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(premiumBundle);
	}

	@Override
	public void delete(int premiumBundle) {
		// TODO Auto-generated method stub
		dao.deleteById(premiumBundle);
	}

}
