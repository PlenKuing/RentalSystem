package com.plenkuing.rentalSystem.dao;

import com.plenkuing.rentalSystem.entity.Host;

//屋主类接口
/*
 *功能：
 *增  改 
 *查：
 *	  根据 姓名查 防止注册重复用户名 用于注册
 *	  根据id查，查出密码与输入密码比较 用于登录
 * */
public interface  HostDao {
	public void save(Host host);
	public void update(Host host);

	public Host findByName(String name);
	public Host findById(int id);
}
