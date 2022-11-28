package com.fanda.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
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
	@Column(name = "restaurant_id")
	Integer restaurantId;
	
	@Column (name = "name")
	String name;
	
	@Column(name = "main_image")
	String mainImage;
	
	@Column(name = "total_rate")
	Double totalRate;
	

	@Temporal(TemporalType.DATE)
	@Column(name = "open_time")
	Date openTime;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "close_time")
	Date closeTime;
	
	@JsonIgnore
	@OneToMany(mappedBy = "restaurantId" )
	List<RestaurantLocation> listLocation;
	
	@JsonIgnore
	@OneToMany(mappedBy = "restaurant" )
	List<Favorite> favorite ;
	
	@JsonIgnore
	@OneToMany(mappedBy = "restaurant" )
	List<Review> review  ;
	
}
