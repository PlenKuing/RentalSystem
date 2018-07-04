package com.plenkuing.rentalSystem;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


import com.plenkuing.rentalSystem.entity.Student;
import com.plenkuing.rentalSystem.untils.SqlSessionFactoryUtil;

public class TsetStudentDao {
	/*测试插入*/	
	@Test
	public void testSave() throws Exception {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
		//根据给定的时间生成Date;
		DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		Date myDate1 = dateFormat1.parse("2009-06-01");
		Student stu = new Student();
		stu.setBirthday(myDate1 );
		stu.setGender("m");
		stu.setAddress("广东");
		stu.setName("张四");
		stu.setPassword("23424");
		stu.setPhone("1232412343");
		sqlSession.insert("StudentMapper.saveStudent", stu);
		sqlSession.close();
	}
	
	
	/*测试通过id查找*/
	@Test 
	public void testFindStudentById() {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
		Student Student = sqlSession.selectOne("StudentMapper.findStudentById",2);
		System.out.println(Student);
		sqlSession.close();
	}
	
	
	/*测试根据用户名查找*/
	@Test 
	public void testFindStudentByName() {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
		Student Student = sqlSession.selectOne("StudentMapper.findStudentByName","grg");
		System.out.println(Student);
		sqlSession.close();
	}
	
	/*测试修改*/
	@Test
	public void testUpdate() throws ParseException {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
		Student Student = sqlSession.selectOne("StudentMapper.findStudentByName","grg");
		Student.setAddress("福建集美厦门");
		Student.setName("张五");
		Student.setPhone("13368568845");
		//根据给定的时间生成Date;
		//DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		//Date myDate1 = dateFormat1.parse("2009-06-01");
		//Student.setBirthday(myDate1);
		sqlSession.update("StudentMapper.updateStudent", Student);
		sqlSession.close();
	}
}
