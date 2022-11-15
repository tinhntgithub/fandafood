package com.fanda.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "review")
public class Review implements Serializable {
	@Id
	@Column(name="review_id")
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
	Restaurant restaurantIdReview;
}
