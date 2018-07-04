package com.plenkuing.rentalSystem.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.plenkuing.rentalSystem.dao.HostDao;
import com.plenkuing.rentalSystem.entity.Host;
import com.plenkuing.rentalSystem.untils.SqlSessionFactoryUtil;

@Repository
public class HostDaoImpl implements HostDao {

	@Override
	public void save(Host host) {
		//通过工厂类获取
		SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
        //进行插入操作
        sqlSession.insert("HostMapper.saveHost", host);
        //释放资源，每一个sqlSession就是一个连接
        sqlSession.close();

	}

	@Override
	public void update(Host host) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
		sqlSession.update("HostMapper.updateHost", host);
		sqlSession.close();
	}

	@Override
	public Host findByName(String name) {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
		Host host = sqlSession.selectOne("HostMapper.findHostByName",name);
		sqlSession.close();
		return host;
		
	}

	@Override
	public Host findById(int id) {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
		Host host = sqlSession.selectOne("HostMapper.findHostById",id);
		sqlSession.close();
		return host;
	}

}
