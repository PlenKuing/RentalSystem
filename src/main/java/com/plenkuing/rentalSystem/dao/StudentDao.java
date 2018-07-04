package com.plenkuing.rentalSystem.dao;

import com.plenkuing.rentalSystem.entity.Student;



/*
 * 学生接口
 * 
 * 增:注册
 * 改:修改个人信息
 * 查:
 *  根据姓名查 防止注册重复
 *  根据id 用于登录验证
 * */
public interface StudentDao {
	public void save(Student student);
	public void update(Student student);
	public Student findByName(String name);
	public Student findById(int id);
	
}
