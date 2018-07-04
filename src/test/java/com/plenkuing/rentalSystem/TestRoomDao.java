package com.plenkuing.rentalSystem;


import java.util.List;

import org.junit.Test;

import com.plenkuing.rentalSystem.dao.RoomDao;
import com.plenkuing.rentalSystem.dao.impl.RoomDaoImpl;
import com.plenkuing.rentalSystem.entity.Room;


public class TestRoomDao {
	/*
	 * 房屋信息
	 * 增 删 改 
	 * 查：
	 * 	根据地址查  有多个 list
	 * 	根据房主ID查  有多个 list
	 * 
	 * */
	/*测试插入*/	

	 RoomDao dao = new RoomDaoImpl();
	 //增
	@Test
	public void testSave() {
		Room room = new Room();
		room.setAddress("guangdong");
		room.setCost(101.20);
		room.setCount(10);
		room.setHostId(1);
		room.setImage1("//eaeffea");
		room.setImage2(null);
		room.setStatus("t");
		room.setType("d");
		dao.save(room);
	}
	
	//删
	@Test
	public void testDelete() {
		dao.delete(2);
	}
	
	@Test
	public void testUpdate() {
		List<Room> list=dao.findRoomByHostId(2);
		Room room = list.get(0);
		room.setAddress("厦门");
		room.setCost(1.20);
		room.setCount(12);
		room.setHostId(1);
		room.setImage1("//d:dea");
		room.setImage2(null);
		room.setStatus("t");
		room.setType("d");
		dao.update(room);
	}
	
	/*根据地址查  有多个 list*/
	@Test 
	public void testFindRoomByAddress() {
		List<Room> list=dao.findRoomByAddress("厦门");
		for (Room room : list) {
			System.out.println(room);
		}
	}
	
	
	/*根据房主ID查  有多个 list*/
	@Test 
	public void testFindRoomByHostId() {
		List<Room> list=dao.findRoomByHostId(2);
		//Room room = list.get(0);
		for (Room room : list) {
			System.out.println(room);
		}
		//System.out.println(room);
	}
	
	/*查找所有房屋 有多个 list*/
	@Test 
	public void testFindRoomInfo() {
		List<Room> list=dao.findRoomInfo();
		//Room room = list.get(0);
		for (Room room : list) {
			System.out.println(room);
		}
		//System.out.println(room);
	}
	
	/*查找单个房屋 用于修改回显*/
	@Test 
	public void testFindRoomById() {
		Room room =dao.findRoomById(11);
		//Room room = list.get(0);
			System.out.println(room);
		
		//System.out.println(room);
	}
	
	
}
