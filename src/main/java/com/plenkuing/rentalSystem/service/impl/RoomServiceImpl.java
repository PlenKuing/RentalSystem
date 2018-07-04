package com.plenkuing.rentalSystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plenkuing.rentalSystem.dao.RoomDao;
import com.plenkuing.rentalSystem.entity.Room;
import com.plenkuing.rentalSystem.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	RoomDao roomDao;
	
	
	@Override
	public void saveRoomInfo(Room room) {
		roomDao.save(room);
	}

	@Override
	public void updateRoomInfo(Room room) {
		roomDao.update(room);
	}

	@Override
	public void deleteRoomInfo(int id) {
		roomDao.delete(id);

	}

	@Override
	public Room getRoomById(int id) {
		Room room = roomDao.findRoomById(id);
		return room;
	}
	
	@Override
	public List<Room> getRoomByHostId(int hostId) {
		// TODO Auto-generated method stub
		return roomDao.findRoomByHostId(hostId);
	}

	@Override
	public List<Room> getRoomByAddress(String address) {
		// TODO Auto-generated method stub
		return roomDao.findRoomByAddress(address);
	}

	/* (non-Javadoc)
	 * @see com.plenkuing.rentalSystem.service.RoomService#getRoomInfo()
	 */
	@Override
	public List<Room> getRoomInfo() {
		// TODO Auto-generated method stub
		return roomDao.findRoomInfo();
	}


	
	

	
}
