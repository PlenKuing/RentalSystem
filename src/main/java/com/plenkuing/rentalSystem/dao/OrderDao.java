package com.plenkuing.rentalSystem.dao;



import java.util.List;
import com.plenkuing.rentalSystem.entity.Order;


/*
 * 订单类
 * 增 
 * 查:
 * 	根据屋主查    多个 返回list
 * 	根据学生查    多个 返回list
 * 
 * */
public interface OrderDao {
	public void save(Order order);

	public List<Order> findByHostId(int hostId);
	public List<Order> findByStudentId(int studentId);
}
