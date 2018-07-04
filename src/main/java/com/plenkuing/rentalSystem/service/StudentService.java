package com.plenkuing.rentalSystem.service;

import com.plenkuing.rentalSystem.entity.Student;

public interface StudentService {
	/*
	 * 登录
	 * 注册
	 * 修改个人信息
	 * */
	
	public Student login(int id,String password);
	public int register(Student student);
	public Student getDetails(int id);
	public void updateDetails(Student student);
}
