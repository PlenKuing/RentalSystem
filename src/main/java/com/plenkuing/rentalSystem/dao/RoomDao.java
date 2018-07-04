package com.plenkuing.rentalSystem.dao;




import java.util.List;

import com.plenkuing.rentalSystem.entity.Room;

/*
 * 房屋信息
 * 增 删 改 
 * 查：
 * 	根据地址查  有多个 list
 * 	根据房主ID查  有多个 list
 * 
 * */
public interface RoomDao {
	public void save(Room room);
	public void update(Room room);
	public void delete(int id);
	
	public Room findRoomById(int id);
	
	public List<Room> findRoomByAddress(String address);
	public List<Room> findRoomByHostId(int hostId);
	public List<Room> findRoomInfo();
}
