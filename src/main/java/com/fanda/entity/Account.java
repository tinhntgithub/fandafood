package com.fanda.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@SuppressWarnings("serial")
@Data
@Entity 
@Table(name = "account")
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable{
	@Id
	String username;
    @JsonIgnore
	String password;
	@Column(name="first_name")
	String firstname;
	@Column(name="last_name")
	String lastname;
	@Column(name="phone_number")
	String phone;
	String email;
	boolean active;
	boolean gender;
	@Temporal(TemporalType.DATE)
	@Column(name = "createdate")
	Date createdate = new Date();
	
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
	
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<Review> review;
}
