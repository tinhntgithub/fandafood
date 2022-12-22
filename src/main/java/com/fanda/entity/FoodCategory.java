package com.fanda.entity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
@Entity 
@Table(name = "foodCategory")
public class FoodCategory implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "food_cate_id")
	Integer foodCateId;
	
	@Column(name = "name")
	String name;
		
	@JsonIgnore
	@OneToMany(mappedBy = "foodCate")
	List<Food> ListFoodByFoodCate;
}
