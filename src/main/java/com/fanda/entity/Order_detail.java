package com.fanda.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name = "order_detail")
public class Order_detail implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer order_detail_id;
	Double price;
	Integer quantity;
	@ManyToOne
	@JoinColumn(name = "food_id")
	Food food;
	@ManyToOne
	@JoinColumn(name = "order_id")
	Order order;
}
