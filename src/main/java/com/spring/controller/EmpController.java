package com.spring.controller;

import java.sql.SQLException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.Employee;
import com.spring.service.EmpService;
import com.spring.service.EmpServiceImpl;

import lombok.Setter;
import lombok.val;

@Controller(value="contr")
public class EmpController {
	@Autowired
	@Qualifier(value="servimp")
	private EmpService empserv;
	/*
	public static void main(String[] args) throws SQLException {
		ConfigurableApplicationContext app = new ClassPathXmlApplicationContext("springconfig.xml");
		EmpService empser = (EmpService) app.getBean("ee");
		Employee e1 = new Employee();
		e1.setEid(1);
		e1.setEname("tejas");
		e1.setSalary(20000);
		int i = empser.saveEmp(e1);
		System.out.println(i);
		//DriverManagerDataSource
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
		
		int i = empserv.saveEmp(e1);
	///	int i=1;
		System.out.println(i+" Inserted..");
		ModelAndView mav = null;
		return mav = i!=0 ? new ModelAndView("success") : new ModelAndView("failure");
	}
	
	
}
	
	
	
	
	

