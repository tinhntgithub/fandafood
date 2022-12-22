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

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="picture")
public class Picture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Picture_id")
	int Id ;
	
	
	Integer picture;
	
	@ManyToOne
	@JoinColumn(name= "food_id")
	Food food;
}
