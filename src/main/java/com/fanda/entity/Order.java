package com.fanda.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order implements Serializable {
	/**
	 * 
	 */

	@Id
	@Column(name="order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String note;
	Double total;
	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	Date date = new Date();
	Integer status;

	@ManyToOne
	@JoinColumn(name = "username")
	Account account;

	@ManyToOne
	@JoinColumn(name = "voucher_id")
	Voucher voucher;
	
	@ManyToOne
	@JoinColumn(name = "restaraunt_id")
	Restaurant restaurant;

	@ManyToOne @JoinColumn(name = "address_id")
	Delivery_address address;

	@JsonIgnore
	@OneToMany(mappedBy = "order")
	List<Order_detail> orderDetails;

}
