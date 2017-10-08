package com.spring.model;



import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString

public class Employee {

	private int eid;
	private String ename;
	private double salary;
	
}
