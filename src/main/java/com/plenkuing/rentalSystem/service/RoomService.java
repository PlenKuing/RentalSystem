package com.plenkuing.rentalSystem.service;

import java.util.List;

import com.plenkuing.rentalSystem.entity.Room;

public interface RoomService {


	public void saveRoomInfo(Room room);
	public void updateRoomInfo(Room room);
	public void deleteRoomInfo(int id);
	//根据Id 查找
	public Room getRoomById(int id);
	//根据户主Id查找
	public List<Room> getRoomByHostId(int id);
	//根据地址查找
	public List<Room> getRoomByAddress(String address);
	//查找全部
	public List<Room> getRoomInfo();

	
}
