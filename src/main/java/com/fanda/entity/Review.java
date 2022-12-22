package com.fanda.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "review")
@AllArgsConstructor
@NoArgsConstructor
public class Review implements Serializable {
	@Id
	@Column(name="review_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer reviewId;
	
	@Column(name="message")
	String message;
	
	@Column(name="rate")
	Double rate;
		
	@Column(name="vote")
	Boolean vote;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name = "date")
	LocalDateTime date = LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));	
	
	
	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	Restaurant restaurant;

	@ManyToOne
	@JoinColumn(name = "food_id")
	Food food;

	@ManyToOne
	@JoinColumn(name = "user_id")
	Account account;
}
