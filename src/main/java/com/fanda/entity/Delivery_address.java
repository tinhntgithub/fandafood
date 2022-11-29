package com.fanda.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "delivery_address")
public class Delivery_address implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer Id;
	String name;
	String address;
	Boolean Active;

	@ManyToOne
	@JoinColumn(name = "username")
	Account account;
	
	@OneToMany(mappedBy = "deliAdd")
	List<Order> order;
}
