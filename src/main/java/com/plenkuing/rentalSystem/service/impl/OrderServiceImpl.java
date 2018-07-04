package com.plenkuing.rentalSystem.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plenkuing.rentalSystem.dao.OrderDao;
import com.plenkuing.rentalSystem.entity.Order;
import com.plenkuing.rentalSystem.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDao orderDao;

	@Override
	public void saveOrder(int studentId,int hostId,int roomId ) {
		Order order = new Order();
		order.setHostId(hostId);
		order.setRoomId(roomId);
		order.setStudentId(studentId);
		Date date = new Date();
		order.setTime(date);
		orderDao.save(order);
	}

	@Override
	public List<Order> getOrderByStudentId(int studentId) {
		return orderDao.findByStudentId(studentId);
	}

	@Override
	public List<Order> getOrderByHostId(int hostId) {
		return orderDao.findByHostId(hostId);
	}

}
