package com.plenkuing.rentalSystem.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.plenkuing.rentalSystem.dao.RoomDao;
import com.plenkuing.rentalSystem.entity.Room;
import com.plenkuing.rentalSystem.untils.SqlSessionFactoryUtil;

@Repository
public class RoomDaoImpl implements RoomDao {
	/* (non-Javadoc)
	 * @see com.plenkuing.rentalSystem.dao.RoomDao#findRoomById(int)
	 */
	

	/*
	 * 房屋信息
	 * 增 删 改 
	 * 查：
	 * 	根据Id查
	 * 	根据地址查  有多个 list
	 * 	根据房主ID查  有多个 list
	 * 
	 * */
	@Override
	public void save(Room room) {
		// TODO Auto-generated method stub
		SqlSession sqlSession =SqlSessionFactoryUtil.getSession();
		sqlSession.insert("RoomMapper.saveRoom", room);
		sqlSession.close();
	}

	@Override
	public void update(Room room) {
		// TODO Auto-generated method stub
		SqlSession sqlSession =SqlSessionFactoryUtil.getSession();
		sqlSession.update("RoomMapper.updateRoom", room);
		sqlSession.close();
	}
	
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		SqlSession sqlSession =SqlSessionFactoryUtil.getSession();
		sqlSession.update("RoomMapper.deleteRoom", id);
		sqlSession.close();
	}
	
	
	@Override
	public Room findRoomById(int id) {
		SqlSession sqlSession =SqlSessionFactoryUtil.getSession();
		Room room = sqlSession.selectOne("RoomMapper.findRoomById", id);
		sqlSession.close();
		return room;
	}
	
	@Override
	public List<Room> findRoomByAddress(String address) {		
		// TODO Auto-generated method stub
		SqlSession sqlSession =SqlSessionFactoryUtil.getSession();
		List<Room> roomList = sqlSession.selectList("RoomMapper.findRoomByAddress", address);
		sqlSession.close();
		return roomList;
	}

	@Override
	public List<Room> findRoomByHostId(int hostId) {
		SqlSession sqlSession =SqlSessionFactoryUtil.getSession();
		List<Room> roomList = sqlSession.selectList("RoomMapper.findRoomByHostId", hostId);
		sqlSession.close();
		return roomList;
	}

	/* (non-Javadoc)
	 * @see com.plenkuing.rentalSystem.dao.RoomDao#findRoomInfo()
	 */
	@Override
	public List<Room> findRoomInfo() {
		SqlSession sqlSession =SqlSessionFactoryUtil.getSession();
		List<Room> roomList = sqlSession.selectList("RoomMapper.findRoomInfo");
		sqlSession.close();				
		return roomList;
	}

}
