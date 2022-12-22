package com.fanda.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fanda.dao.OrderDAO;
import com.fanda.dao.RestaurantDAO;
import com.fanda.entity.Order;
import com.fanda.entity.Restaurant;


@RestController
@RequestMapping("/rest/statistical")
public class StatisticalRestController {
	
	@Autowired
	OrderDAO dao;
	
	@Autowired
	RestaurantDAO daoRes;
	
	@Autowired
	HttpServletRequest request;
	
	@GetMapping("/restaurant")
	public List<Order> getStatisticalByRes() {
		Restaurant res = daoRes.findByUser(request.getRemoteUser()).get();
		return dao.getListOderbyRestaurantAndStatus(res.getRestaurantId(),2);
	}
	
	@GetMapping("/total")
	public Object getStatisticalTotalByRes() {
		Restaurant res = daoRes.findByUser(request.getRemoteUser()).get();
		return dao.getListStatisticalTotalByResStatus(res.getRestaurantId(),2);
	}
	
	@GetMapping("/restaurant/date")
	public List<Order> getStatisticalByResByDate(@RequestParam("dateStart") String dateStart,@RequestParam("dateEnd") String dateEnd) {
		Restaurant res = daoRes.findByUser(request.getRemoteUser()).get();
		return dao.getListOderbyRestaurantAndStatusByDate(res.getRestaurantId(),2,dateStart,dateEnd);
	}
	
	@GetMapping("/total/date")
	public Object getStatisticalTotalByRes(@RequestParam("dateStart") String dateStart,@RequestParam("dateEnd") String dateEnd) {
		Restaurant res = daoRes.findByUser(request.getRemoteUser()).get();
		return dao.getListStatisticalTotalByResStatusByDate(res.getRestaurantId(),2,dateStart,dateEnd);
	}
	
	
	// nhơn mới cập nhật cái này - - - -
	@GetMapping("/thongke")
	public List<Order> getThongKe(@RequestParam("restaurantId") Integer restaurantId,@RequestParam("startDate") String startDate,@RequestParam("endDate") String endDate ){
		
		return dao.getOrderByRestaurantAndByStatusAndByDate(restaurantId, startDate, endDate);
	}
	
	
}
