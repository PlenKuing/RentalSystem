package com.plenkuing.rentalSystem;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.plenkuing.rentalSystem.dao.HostDao;
import com.plenkuing.rentalSystem.dao.impl.HostDaoImpl;
import com.plenkuing.rentalSystem.entity.Host;
import com.plenkuing.rentalSystem.untils.SqlSessionFactoryUtil;

@SpringBootTest
public class TestHostDao {
	
	HostDao dao = new HostDaoImpl();
	/*测试插入*/	
	@Test
	public void testSave() {
		Host host = new Host();
		host.setAddress("广东");
		host.setName("张四");
		host.setPassword("23424");
		host.setPhone("1232412343");
		dao.save(host);
	}
	
	/*测试通过id查找*/
	@Test 
	public void testFindHostById() {
		Host host  = dao.findById(2);
		System.out.println(host);
	}
	
	
	/*测试根据用户名查找*/
	@Test 
	public void testFindHostByName() {
		String name = "张6";
		Host host  = dao.findByName(name);
		System.out.println(host);
	}
	
	/*测试修改*/
	@Test
	public void testUpdate() {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
		Host host = sqlSession.selectOne("HostMapper.findHostByName","张五");
		host.setAddress("福建集美");
		host.setName("张6");
		host.setPhone("138845");
		sqlSession.update("HostMapper.updateHost", host);
		sqlSession.close();
		dao.update(host);
	}
}
