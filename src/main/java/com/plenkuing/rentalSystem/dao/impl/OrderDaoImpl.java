package com.plenkuing.rentalSystem.dao.impl;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.plenkuing.rentalSystem.dao.OrderDao;
import com.plenkuing.rentalSystem.entity.Order;
import com.plenkuing.rentalSystem.untils.SqlSessionFactoryUtil;

@Repository
public class OrderDaoImpl implements OrderDao {

	@Override
	public void save(Order order) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
		sqlSession.insert("OrderMapper.saveOrder",order);
		sqlSession.close();

	}

	@Override
	public List<Order> findByHostId(int hostId) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
		List<Order> orderList = sqlSession.selectList("OrderMapper.findOrderByHostId",hostId);
		sqlSession.close();
		return orderList;
	}

	@Override
	public List<Order> findByStudentId(int studentId) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
		List<Order> orderList = sqlSession.selectList("OrderMapper.findOrderByStudentId",studentId);
		sqlSession.close();
		return orderList;
	}

}
