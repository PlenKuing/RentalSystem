package com.plenkuing.rentalSystem.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.plenkuing.rentalSystem.entity.Order;
import com.plenkuing.rentalSystem.entity.Room;
import com.plenkuing.rentalSystem.service.OrderService;
import com.plenkuing.rentalSystem.service.RoomService;

@Controller
public class OrderController {
	@Autowired
	OrderService orderService;
	@Autowired
	RoomService roomService;
	
	//根据学生id查询订单
	@RequestMapping(value="/studentOrder",method=RequestMethod.GET)
	public String studentOrder(HttpSession session,Model model) {
		int studentId =Integer.parseInt((String) session.getAttribute("id"));
		//查找学生的订单并显示
		List<Order> orders = orderService.getOrderByStudentId(studentId);
		model.addAttribute("orders",orders);
		return "studentOrder";
	}
	
	//根据户主id查询订单
	@RequestMapping(value="/hostOrder",method=RequestMethod.GET)
	public String hostOrder(HttpSession session,Model model) {
		int hostId =Integer.parseInt((String) session.getAttribute("id"));
		//查找学生的订单并显示
		List<Order> orders = orderService.getOrderByHostId(hostId);
		for (Order order : orders) {
			System.out.println(order.getStudent());
		}
		model.addAttribute("orders",orders);
		return "hostOrder";
	}
	
	
	//新增订单
	@RequestMapping(value="/saveOrder",method=RequestMethod.GET)
	public String saveOrder(@Param("hostId") int hostId,@Param("roomId") int roomId,
		HttpSession session) {
		int studentId =Integer.parseInt((String) session.getAttribute("id"));
		orderService.saveOrder(studentId, hostId, roomId);
		//更改房屋的状态
		Room room = roomService.getRoomById(roomId);
		room.setStatus("b");
		roomService.updateRoomInfo(room);
		return "redirect:/studentOrder";
	}
}
