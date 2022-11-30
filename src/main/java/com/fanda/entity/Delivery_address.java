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


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "delivery_address")
@AllArgsConstructor
@NoArgsConstructor
public class Delivery_address implements Serializable {
	@Id
	@Column(name = "address_id")
	Integer id;
	String phone;
	String address;
	Boolean Active;

	@ManyToOne
	@JoinColumn(name = "username")
	Account account;
	
	@JsonIgnore
	@OneToMany(mappedBy = "address")
	List<Order> orders;
}
