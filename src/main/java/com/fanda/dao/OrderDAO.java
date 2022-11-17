package com.fanda.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fanda.entity.Order;

public interface OrderDAO extends JpaRepository<Order, Integer>{
	@Query("SELECT new YourOrder(o.order, SUM(o.price * o.quantity)) FROM OrderDetail o where o.order.account.username=?1 group by o.order")
	List<YourOrder> GetYourOrder(String username);
	
	@Query("SELECT new YourOrder(o.order, SUM(o.price * o.quantity)) FROM OrderDetail o  group by o.order")
	List<YourOrder> GetYourOrderAll();
	
	@Query("SELECT new YourOrder(o.order, SUM(o.price * o.quantity)) FROM OrderDetail o where o.order.id = ?1 group by o.order")
	YourOrder findYourOrder(Long username);
	
//	@Query( value = "select * from Orders\r\n"
//			+ "where Createdate between  ?1 and  ?2 " ,nativeQuery = true)
//	List<Order> ReportSumTunrnoversOrder(Date from, Date to);
	
	@Query("SELECT new ReportOrder(od.order, COUNT(od.product), SUM(od.price*od.quantity)) FROM OrderDetail od WHERE od.order.createDate BETWEEN ?1 AND ?2 and od.order.status=3  group by od.order")
	List<ReportOrder> ReportSumTunrnoversOrder(Date from, Date to);
	
	@Query("SELECT new ReportOrder(od.order,COUNT(od.product), SUM(od.price*od.quantity)) FROM OrderDetail od WHERE od.order.status=3  group by od.order")
	List<ReportOrder> ReportSumTunrnoversOrder();
	
	@Query("SELECT new ReportUser(u, SUM(od.price*od.quantity)) FROM Account u LEFT OUTER JOIN Order o  On u.id = o.account.id LEFT OUTER JOIN OrderDetail od ON od.order.id=o.id WHERE u.Createdate BETWEEN ?1 AND ?2 GROUP BY u")
	List<ReportUser> ReportUserDate(Date from, Date to);
	
	@Query("SELECT new ReportUser(u, SUM(od.price*od.quantity)) FROM Account u LEFT OUTER JOIN Order o  On u.id = o.account.id LEFT OUTER JOIN OrderDetail od ON od.order.id=o.id GROUP BY u")
	List<ReportUser> ReportUser();
	
	@Query(value = "select COUNT(*) from orders where Status = 3" , nativeQuery = true)
	Integer countOrder();
	
	@Query("select SUM(o.price) from OrderDetail o where o.order.status = 3 ")
	Double sumTotal();
	
}
