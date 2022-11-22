package com.fanda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fanda.entity.Prioritized;

public interface PrioritizedDAO extends JpaRepository<Prioritized, Integer>{

}
