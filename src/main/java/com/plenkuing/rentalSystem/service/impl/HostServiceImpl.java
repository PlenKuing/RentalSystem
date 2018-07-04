package com.plenkuing.rentalSystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.plenkuing.rentalSystem.dao.HostDao;
import com.plenkuing.rentalSystem.entity.Host;
import com.plenkuing.rentalSystem.service.HostService;


@Service
public class HostServiceImpl implements HostService {
	@Autowired
	HostDao hostDao;
	
	@Override
	public Host login(int id, String password) {
		Host host;
		
		if((host=hostDao.findById(id))!=null 
				&& host.getPassword().equals(password)) {
			System.out.println(host.getName());
			return host;
		}
		return null;
	}

	@Override
	//注册成功的话 返回注册到的账户id回去 不成功返回-1
	public int register(Host host) {
		//查看用户名是否存在
		if((hostDao.findByName(host.getName()))==null) {
			hostDao.save(host);
			//插入之后返回注册id，作为账号返回
			hostDao.findByName(host.getName()).getId();
			return 	hostDao.findByName(host.getName()).getId();
		}
		return -1;
	}

	@Override
	public void updateDetails(Host host) {
		hostDao.update(host);
	}
	
	@Override
	public Host getDetails(int id) {
		// TODO Auto-generated method stub
		return hostDao.findById(id);
	}

}
