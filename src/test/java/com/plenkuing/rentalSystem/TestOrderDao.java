package com.plenkuing.rentalSystem;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.plenkuing.rentalSystem.dao.OrderDao;
import com.plenkuing.rentalSystem.dao.impl.OrderDaoImpl;
import com.plenkuing.rentalSystem.entity.Order;

public class TestOrderDao {
	OrderDao dao = new OrderDaoImpl();
	/*测试插入*/	
	@Test
	public void testSave() throws ParseException {
		Order order = new Order();
		//获得2010年9月13日22点36分01秒 的Date对象
		//DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//Date myDate2 = dateFormat2.parse("2016-09-13 22:36:01");
		Date date = new Date();
		order.setHostId(1);
		order.setRoomId(1);
		order.setStudentId(1);
		order.setTime(date);
		dao.save(order);
	}
	
	/*测试通过学生id查找*/
	@Test 
	public void testFindOrderByStudentId() {
		List<Order> Order  = dao.findByStudentId(10000);
		for (Order order2 : Order) {
			System.out.println(order2.getHost().getPhone());
		}
	}
	
	
	/*测试根据屋主id查找*/
	@Test 
	public void testFindOrderByHostId() {
		
		List<Order> Order  = dao.findByHostId(10013);
		for (Order order2 : Order) {
			System.out.println(order2.getStudent());
		}
	}
}
