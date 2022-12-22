package com.fanda.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fanda.entity.Order;

public interface OrderDAO extends JpaRepository<Order, Integer>{
	@Query("select o from Order o where o.account.username = ?1 ")
	List<Order> findOrderByUser(String username);
	
	@Query("select o from Order o where o.account.username = ?1 and o.status = ?2 ")
	List<Order> listTrueOrders(String acc,int trangthai);
	
	@Query(value="SELECT * FROM fandafood.orders where restaraunt_id = ?1",nativeQuery=true)
	List<Order> getListOderbyRestaurant(Integer idRestaurant);
	
	@Query(value="SELECT * FROM fandafood.orders where restaraunt_id = ?1 and status = ?2",nativeQuery=true)
	List<Order> getListOderbyRestaurantAndStatus(Integer idRestaurant,Integer oderStatus);
	
	@Query(value="SELECT * FROM fandafood.orders where restaraunt_id = ?1 and status = ?2 and date > ?3 and date < ?4 ",nativeQuery=true)
	List<Order> getListOderbyRestaurantAndStatusByDate(Integer idRestaurant,Integer oderStatus,String dateStar,String dateEnd);
	
	@Query(value="SELECT sum(total) sum, count(*) count FROM fandafood.orders where restaraunt_id = ?1 and status = ?2",nativeQuery=true)
	Object[] getListStatisticalTotalByResStatus(Integer idRestaurant,Integer oderStatus);
	
	@Query(value="SELECT sum(total) sum, count(*) count FROM fandafood.orders where restaraunt_id = ?1 and status = ?2 and date > ?3 and date < ?4",nativeQuery=true)
	Object[] getListStatisticalTotalByResStatusByDate(Integer idRestaurant,Integer oderStatus,String dateStar,String dateEnd);
	
	
	
	
}
