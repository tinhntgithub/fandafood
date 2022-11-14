package com.fanda.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.entity.Cart;
import com.entity.Menu_cate;
import com.entity.Picture;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "food")
@NoArgsConstructor
public class Food implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "food_id")
	Integer food_id;
	String name;
	String image;
	Double price;
	String description;
	Boolean Status;
	@ManyToOne
	@JoinColumn(name = "food_cate_id")
	Food_category food_category;
	@ManyToOne
	@JoinColumn(name = "menu_id")
	Menu_cate menu_cate;
	@JsonIgnore
	@OneToMany(mappedBy = "food")
	List<Order_detail> order_detail;
	@JsonIgnore
	@OneToMany(mappedBy = "food")
	List<Cart> cart;
	@JsonIgnore
	@OneToMany(mappedBy = "food")
	List<Picture> picture;
}
