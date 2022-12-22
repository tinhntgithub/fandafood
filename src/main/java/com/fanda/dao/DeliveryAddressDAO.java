package com.fanda.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fanda.entity.Delivery_address;







public interface DeliveryAddressDAO extends JpaRepository<Delivery_address, Integer>{
	@Query("select a from Delivery_address a where a.account.username = ?1")
	List<Delivery_address> findAddresses(String i);
	
	@Query("select a from Delivery_address a where a.account.username = ?1 and a.Active=true ")
	Optional<Delivery_address> findAddressTrue(String i);
	
	@Query("select a from Delivery_address a where a.id = ?1 and a.Active=true ")
	Optional<Delivery_address> findAddressTrue_address(int a,String i);
}
