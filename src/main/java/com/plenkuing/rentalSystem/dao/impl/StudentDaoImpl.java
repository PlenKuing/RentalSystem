package com.plenkuing.rentalSystem.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.plenkuing.rentalSystem.dao.StudentDao;
import com.plenkuing.rentalSystem.entity.Student;
import com.plenkuing.rentalSystem.untils.SqlSessionFactoryUtil;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Override
	public void save(Student Student) {
		//通过工厂类获取
		SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
        //进行插入操作
        sqlSession.insert("StudentMapper.saveStudent", Student);
        //释放资源，每一个sqlSession就是一个连接
        sqlSession.close();

	}

	@Override
	public void update(Student Student) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
		sqlSession.update("StudentMapper.updateStudent", Student);
		sqlSession.close();
	}

	@Override
	public Student findByName(String name) {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
		Student Student = sqlSession.selectOne("StudentMapper.findStudentByName",name);
		sqlSession.close();
		return Student;
		
	}

	@Override
	public Student findById(int id) {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSession();
		Student Student = sqlSession.selectOne("StudentMapper.findStudentById",id);
		sqlSession.close();
		return Student;
	}

}
