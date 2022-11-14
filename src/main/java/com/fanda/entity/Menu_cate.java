package com.fanda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Menu_cate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Menu_id")
	int Id ;
	Integer restaurant_id;
	String cate_name;
}
