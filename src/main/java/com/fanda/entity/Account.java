package com.fanda.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@SuppressWarnings("serial")
@Data
@Entity 
@Table(name = "account")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Account implements Serializable{
	@Id
	String username;
	String password;
	@Column(name = "first_name")
	String firstname;
	@Column(name = "last_name")
	String lastname;
	@Column(name = "phone_number")
	String phonenumber;
	String email;
	boolean Active;
	boolean Gender;
	@Temporal(TemporalType.DATE)
	@Column(name = "createdate")
	Date Createdate = new Date();
	
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<Order> order;
	
	@JsonIgnore
	@OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
	List<Authority> authorities;
	
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<Cart> cart;
	
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<Delivery_address> delivery_address;
	
	
}
