package com.spring.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.Employee;
import com.spring.service.EmpService;

import lombok.Setter;

@Controller
public class EmpController {
	@Autowired
	private EmpService ee;
	/*public static void main(String[] args) throws SQLException {
		ConfigurableApplicationContext app = new ClassPathXmlApplicationContext("springconfig.xml");
		EmpService empser = (EmpService) app.getBean("ee");
		Employee e1 = new Employee();
		e1.setEid(1);
		e1.setEname("tejas");
		e1.setSalary(20000);
		int i = empser.saveEmp(e1);
		System.out.println(i);
	}*/
	
	@RequestMapping(value="/addemp.htm")
	public ModelAndView m1(HttpServletRequest req,HttpServletResponse resp) throws SQLException {
		String eid = req.getParameter("id");
		String ename = req.getParameter("name");
		String salary = req.getParameter("salary");
	
		System.out.println("I am Here..............");
		Employee e1 = new Employee();
		e1.setEid(Integer.parseInt(eid));
		e1.setEname(ename);
		e1.setSalary(Double.parseDouble(salary));
		/*ConfigurableApplicationContext app = new ClassPathXmlApplicationContext("springconfig.xml");
		EmpService empser = (EmpService) app.getBean("ee");*/
		int i = ee.saveEmp(e1);
		System.out.println(i+" Inserted..");
		ModelAndView mav = null;
		return mav = i!=0 ? new ModelAndView("success") : new ModelAndView("failure");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
} 
