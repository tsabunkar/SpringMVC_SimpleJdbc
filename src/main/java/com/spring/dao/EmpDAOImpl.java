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
	@Autowired
	private DataSource ds;//remember import from javax.sql package

	public int addEmp(Employee e) throws SQLException {
		Connection con = ds.getConnection();
		String sql = "insert into employee_table values(?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, e.getEid());
		ps.setString(2, e.getEname());
		ps.setDouble(3, e.getSalary());
		int i = ps.executeUpdate();
		con.close();
		return i;
	}

}
