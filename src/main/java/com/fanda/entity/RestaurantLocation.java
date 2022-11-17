package com.fanda.entity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
@Entity 
@Table(name = "restaurant_location")
public class RestaurantLocation implements Serializable{
	@Id
	@Column(name = "id")
	Integer id;
	
	@Column(name = "location")
	String location;
		
	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	Restaurant restaurantId;
}
