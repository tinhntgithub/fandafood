package com.fanda.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "voucher_applyto")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class VoucherApply {
    @Id
    Integer id;

    @ManyToOne
	@JoinColumn(name= "voucher_id")
	Voucher voucher;

	Date end_date;
	Date start_date;
}
