package com.fanda.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name = "open_time")
	LocalDateTime openTime = LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name = "close_time")
	LocalDateTime closeTime = LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
	
	@JsonIgnore
	@OneToMany(mappedBy = "restaurantId" )
	List<RestaurantLocation> listLocation;
	
	@JsonIgnore
	@OneToMany(mappedBy = "restaurantIdFavorite" )
	List<Favorite> listFavorite ;
	
	@JsonIgnore
	@OneToMany(mappedBy = "restaurantIdReview" )
	List<Favorite> listReview ;
	
}
