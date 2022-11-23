package com.fanda.service;

import java.util.List;
import java.util.Optional;

import com.fanda.entity.Prioritized;


public interface PrioritizedServ {
	public List<Prioritized> findAll();
	public Optional<Prioritized> findById(int id);
	public Prioritized create(Prioritized Prioritized);
	public Prioritized update (Prioritized Prioritized);	
	public void delete(int Prioritized);
}
