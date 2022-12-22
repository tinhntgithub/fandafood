package com.fanda.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="prioritized")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Prioritized {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	int Id ;
	
	Integer premium_id;
	Date start_date;
	Date end_date;
	
	Boolean active;


	
}
