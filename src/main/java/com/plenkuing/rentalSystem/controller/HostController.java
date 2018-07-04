package com.plenkuing.rentalSystem.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.plenkuing.rentalSystem.controller.ValidGroup.ValidGroup1;
import com.plenkuing.rentalSystem.entity.Host;
import com.plenkuing.rentalSystem.service.HostService;




@Controller
@RequestMapping(value="/host")
public class HostController {
	@Autowired
	HostService hostService;
	//进入户主注册页面
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute(new Host());
		return "hostRegister";
	}
	
	//进行注册
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String processRegister(@Valid Host host,Errors errors,Model model) {
		if(errors.hasErrors()) {
			return "hostRegister";
		}else {
			int id =hostService.register(host);
			if(id==-1) {
				errors.rejectValue("name", "用户已存在");
				return "hostRegister";
			}		
			else {
				model.addAttribute("id",id);
				return "registerOK";
			}		
		}	
	}
	
	//获取个人信息
	@RequestMapping(value="/{hostId}",method=RequestMethod.GET)
	public  String getInfo(@PathVariable int hostId,Model model) {
		Host host = hostService.getDetails(hostId);
		model.addAttribute(host);
		return "hostInfo";
	}
	
	//修改个人信息
	@RequestMapping(value="/updateInfo",method=RequestMethod.POST)
	public  String updateInfo(@Validated(value= {ValidGroup1.class}) Host host,Errors errors) {

		if(errors.hasErrors()) {
			return "redirect:/host/"+host.getId();
		}else {
			hostService.updateDetails(host);;
			return "redirect:/host/"+host.getId();
		}
		
	}

	
}
