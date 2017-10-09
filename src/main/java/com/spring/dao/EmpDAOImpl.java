package com.spring.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.spring.model.Employee;

import lombok.Setter;


public class EmpDAOImpl implements EmpDAO{
	@Setter
	private DataSource ds;//remember import from javax.sql package (or) org.apache.tomcat.dbcp.dbcp.BasicDataSource;

	
	public int addEmp(Employee e) throws SQLException {
		System.out.println("Employee dao Impl start .....");
		Connection con = ds.getConnection();
		String sql = "insert into employee_table values(?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, e.getEid());
		ps.setString(2, e.getEname());
		ps.setDouble(3, e.getSalary());
		int i = ps.executeUpdate();
		con.close();
		System.out.println("Employee dao Impl finish.....");
		return i;
	}

}
