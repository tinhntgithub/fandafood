package com.fanda.entity;

import java.sql.Date;
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

@Table(name = "voucher")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Voucher {

	@Id
	@Column(name = "voucher")
	String id ;
	
	String name;
	Integer discount;
	Integer minimum_order;
	
	@Column(name = "start_date")
	String startDate;
	
	@Column(name = "end_date")
	String endDate;
	
	boolean status;
	
	@JsonIgnore
	@OneToMany(mappedBy = "voucher" )
	List<VoucherApply> voucherApplyto  ;
	
	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	Restaurant voucherResId;
	
}
