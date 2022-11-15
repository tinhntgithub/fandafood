package com.fanda.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "favorite")
public class Favorite implements Serializable {
	@Id
	@Column(name="favorite_id")
	Integer favoriteId;
	
	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	Restaurant restaurantIdFavorite;
}
