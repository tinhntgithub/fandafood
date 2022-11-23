package com.fanda.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
@Data
@Entity 
=======
@Entity
@AllArgsConstructor
@NoArgsConstructor
>>>>>>> 632f0fc5c73bd5e8a742e1751bc2fe68e2281ff7
@Table(name = "cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Cart_id")
	int Id ;
	
	
	Integer qty;
	
	@ManyToOne
	@JoinColumn(name= "username")
	Account account;
	
	@ManyToOne
	@JoinColumn(name= "food_id")
	Food food;
}
