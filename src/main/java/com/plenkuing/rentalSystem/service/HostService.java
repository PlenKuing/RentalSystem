package com.plenkuing.rentalSystem.service;

import com.plenkuing.rentalSystem.entity.Host;
public interface HostService {
	/*
	登录   login
	注册  register
	修改个人信息 updateDetails
	发布房屋信息 saveRoomInfo需要缴纳费用  新增房屋信息 进入缴纳费用框 缴纳之后执行新增sql
			   发布时地址必须选择 
	修改房屋信息  updateRoomInfo	更高	
	删除房屋信息  deleteRoomInfo	删除
	查看与自己相关的订单	 getOrders	 查找返回显示
	 * */
	public Host login(int id,String password);
	public int register(Host host);
	public Host getDetails(int id);
	public void updateDetails(Host host);			

}
