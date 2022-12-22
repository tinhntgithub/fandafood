package com.fanda.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fanda.dao.PrioritizedDAO;
import com.fanda.entity.Prioritized;
import com.fanda.service.PrioritizedServ;

@Service
public class PrioritizedServImpl implements PrioritizedServ{
	@Autowired
	PrioritizedDAO dao;
	@Override
	public List<Prioritized> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<Prioritized> findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public Prioritized create(Prioritized Prioritized) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(Prioritized);
	}

	@Override
	public Prioritized update(Prioritized Prioritized) {
		// TODO Auto-generated method stub
		return dao.saveAndFlush(Prioritized);
	}

	@Override
	public void delete(int Prioritized) {
		// TODO Auto-generated method stub
		dao.deleteById(Prioritized);
	}

}
