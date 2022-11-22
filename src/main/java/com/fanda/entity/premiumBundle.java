package com.fanda.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "premium_bundle")
@NoArgsConstructor
@AllArgsConstructor
public class premiumBundle implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3569928633507574071L;

	@Id
	@Column(name="premium_id")
	Integer premiumId;
	
	@Column(name="name")
	String name;
	
	@Column(name="price")
	Double price;
		
	@Column(name="premium_icon")
	Boolean premiumIcon;
	
	@Column(name="restaurant_tag")
	String restaurantTag;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name = "date")
	LocalDateTime date = LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));	
	
	
}
