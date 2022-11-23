package com.fanda.entity;

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

<<<<<<< HEAD
@Entity 
@Table(name = "role")
@Data
@NoArgsConstructor
@AllArgsConstructor

=======

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "role")
@Entity
>>>>>>> 632f0fc5c73bd5e8a742e1751bc2fe68e2281ff7

public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int Id ;

	String roleName;
	
	@JsonIgnore
	@OneToMany(mappedBy="role")
	List<Authority> authority;
}
