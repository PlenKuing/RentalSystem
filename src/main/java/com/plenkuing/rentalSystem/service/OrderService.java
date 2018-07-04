package com.plenkuing.rentalSystem.service;

import java.util.List;

import com.plenkuing.rentalSystem.entity.Order;

public interface OrderService {
	//交易完成时新增订单
	void saveOrder(int studentId, int hostId, int roomId);
	//根据学生id查找
	public List<Order> getOrderByStudentId(int studentId);
	//根据屋主id查找
	public List<Order> getOrderByHostId(int hostId);


}
