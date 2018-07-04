package com.plenkuing.rentalSystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.plenkuing.rentalSystem.dao.StudentDao;
import com.plenkuing.rentalSystem.entity.Student;
import com.plenkuing.rentalSystem.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentDao studentDao;
	@Override
	public Student login(int id, String password) {
		Student student;
		
		if((student=studentDao.findById(id))!=null 
				&& student.getPassword().equals(password)) {
			System.out.println(student.getName());
			return student;
		}
		return null;
	}
	
	@Override
	public int register(Student student) {
		//查看用户名是否存在
		if((studentDao.findByName(student.getName()))==null) {
			studentDao.save(student);
			//插入之后返回注册id，作为账号返回
			return 	studentDao.findByName(student.getName()).getId();
		}
		return -1;
	}

	@Override
	public void updateDetails(Student student) {
		studentDao.update(student);
	}

	/* (non-Javadoc)
	 * @see com.plenkuing.rentalSystem.service.StudentService#getDetails(int)
	 */
	@Override
	public Student getDetails(int id) {
		// TODO Auto-generated method stub
		return studentDao.findById(id);
	}
	
	
	
	

}
