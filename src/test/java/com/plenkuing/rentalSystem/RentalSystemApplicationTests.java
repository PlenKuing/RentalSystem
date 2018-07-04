package com.plenkuing.rentalSystem;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import com.plenkuing.rentalSystem.entity.Room;
import com.plenkuing.rentalSystem.untils.SqlSessionFactoryUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RentalSystemApplicationTests {

	@Test
	public void contextLoads() throws Exception {
		String pic_time = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());   
        String file_ture_name = DigestUtils.md5DigestAsHex(pic_time.getBytes());
        System.out.println(file_ture_name);
	}
	
	@Test
	public void testSelect() {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
		List<Room> rooms =  sqlSession.selectList("RoomMapper.selectRoom", 4);
		for (Room room : rooms) {
			System.out.println(room);
		}	
		sqlSession.close();
	}

}
