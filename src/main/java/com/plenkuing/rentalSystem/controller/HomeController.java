package com.plenkuing.rentalSystem.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.plenkuing.rentalSystem.controller.FormEntity.User;
import com.plenkuing.rentalSystem.entity.Host;
import com.plenkuing.rentalSystem.entity.Student;
import com.plenkuing.rentalSystem.service.HostService;
import com.plenkuing.rentalSystem.service.StudentService;

@Controller
public class HomeController {
	@Autowired
	StudentService studentService;
	@Autowired 
	HostService hostService;
	
		
	
	@RequestMapping({"/","index"})
	public String home() {
		return "home";
	}
	//进入登录页面
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute(new User());
		return "login";
	}
	
	//进行登录
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String processLogin(User user,RedirectAttributes model,HttpSession session) {
		//获取登录的类型
		String type=user.getType();
		if(type.equals("student")) {//如果登录的是学生
			Student student = studentService.login(user.getId(), user.getPassword());
			if(student==null)
				return "login";	
			
			
			model.addFlashAttribute(student);
			
			//配置session
			session.setAttribute("type", "student");
			session.setAttribute("id", String.valueOf(student.getId()));
			return "redirect:/student/"+student.getId();		
			
		}else if(type.equals("host")){//如果登录的是户主
			Host host=hostService.login(user.getId(), user.getPassword());
			if(host==null)
				return "login";
			model.addFlashAttribute(host);
			//配置session
			session.setAttribute("type", "host");
			session.setAttribute("id", String.valueOf(host.getId()));
	
			return "redirect:/host/"+host.getId();
		}
		return "login";
		
	}
}
