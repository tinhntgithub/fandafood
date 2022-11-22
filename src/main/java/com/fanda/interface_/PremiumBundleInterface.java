package com.fanda.interface_;

import java.util.List;
import java.util.Optional;

import com.fanda.entity.premiumBundle;



public interface PremiumBundleInterface {
	public List<premiumBundle> findAll();
	public Optional<premiumBundle> findById(int id);
	public premiumBundle create(premiumBundle premiumBundle);
	public premiumBundle update (premiumBundle premiumBundle);	
	public void delete(int premiumBundle);
}
