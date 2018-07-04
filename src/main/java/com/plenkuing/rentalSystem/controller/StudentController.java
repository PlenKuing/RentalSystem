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
import com.plenkuing.rentalSystem.entity.Student;
import com.plenkuing.rentalSystem.service.StudentService;

@Controller
@RequestMapping(value="/student")
public class StudentController {
	
	
		
	@Autowired
	StudentService studentService;
	
	
	//进入学生注册页面
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute(new Student());
		return "studentRegister";
	}
	
	//进行注册
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String processRegister(@Valid Student Student,Errors errors,Model model) {
		if(errors.hasErrors()) {
			return "StudentRegister";
		}else {
			int id =studentService.register(Student);
			if(id==-1) {
				errors.rejectValue("name", "用户已存在");
				return "StudentRegister";
			}		
			else {
				model.addAttribute("id",id);
				return "registerOK";
			}		
		}	
	}
		
	
	//获取个人信息
	@RequestMapping(value="/{studentId}",method=RequestMethod.GET)
	public  String home(@PathVariable int studentId,Model model) {
		Student student = studentService.getDetails(studentId);
		model.addAttribute(student);
		return "studentInfo";
	}
	
	
	//修改个人信息
	@RequestMapping(value="/updateInfo",method=RequestMethod.POST)
	public  String updateInfo(@Validated(value= {ValidGroup1.class}) Student student,Errors errors) {
		System.out.println(student);
		if(errors.hasErrors()) {
			return "redirect:/student/"+student.getId();
			
		}else {
			studentService.updateDetails(student);
			return "redirect:/student/"+student.getId();
		}
		
	}
	
			
		
	
}
