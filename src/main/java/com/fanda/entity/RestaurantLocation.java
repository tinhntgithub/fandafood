package com.fanda.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity 
@Table(name = "restaurant_location")
@NoArgsConstructor
@AllArgsConstructor
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
