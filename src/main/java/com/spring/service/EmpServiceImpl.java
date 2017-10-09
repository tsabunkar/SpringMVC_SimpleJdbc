package com.spring.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.spring.dao.EmpDAO;
import com.spring.dao.EmpDAOImpl;
import com.spring.model.Employee;

import lombok.Setter;
@Service
public class EmpServiceImpl implements EmpService{
	@Autowired
	private EmpDAOImpl edao;
	
	public int saveEmp(Employee e) throws SQLException {
		System.out.println("EmpService Implem start...");
		return edao.addEmp(e);
		
	}

}
