package com.spring.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.spring.dao.EmpDAO;
import com.spring.model.Employee;

import lombok.Setter;

public class EmpServiceImpl implements EmpService{
	@Autowired
	private EmpDAO edao;
	
	public int saveEmp(Employee e) throws SQLException {
		return edao.addEmp(e);
	}

}
