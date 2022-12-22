package com.fanda.entity;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "restaurant")
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "restaurant_id")
	Integer restaurantId;
	
	@Column (name = "name")
	String name;
	
	@Column (name = "address")
	String address;
	
	@Column(name = "main_image")
	String mainImage;
	
	@Column(name = "total_rate")
	Double totalRate;
	
	

	@Column(name = "open_time")
	String openTime;
	
	
	@Column(name = "close_time")
	String closeTime;
	
	@ManyToOne
	@JoinColumn(name= "user_id")
	Account account;
	
	@JsonIgnore
	@OneToMany(mappedBy = "restaurantMenu" )
	List<Menu_cate> listMenucate;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "restaurant" )
	List<Review> review  ;
	
	@JsonIgnore
	@OneToMany(mappedBy = "voucherResId" )
	List<Voucher> getlistVoucher  ;

	@ManyToOne
	@JoinColumn(name = "location_id")
	RestaurantLocation locationId;
	boolean active;
}
