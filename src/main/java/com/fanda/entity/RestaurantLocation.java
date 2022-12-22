<<<<<<< HEAD
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
@Table(name = "restaurant_location")
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantLocation implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Integer id;
	
	@Column(name = "location")
	String location;
		
	@JsonIgnore
	@OneToMany(mappedBy = "locationId" )
	List<Restaurant> listResByLocation;
}
=======
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
@Table(name = "restaurant_location")
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantLocation implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Integer id;
	
	@Column(name = "location")
	String location;
		
	@JsonIgnore
	@OneToMany(mappedBy = "locationId" )
	List<Restaurant> listResByLocation;
}
>>>>>>> 0da8e6354590aa75b65d971f44ab9387520b3144
