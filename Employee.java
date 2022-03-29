package com.java.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="EMPLOYEE")
public class Employee {
	
	@Id
	@Column(name="empno")
	private int employeeNumber;

	@Column(name="empname")
	private String employeeName;
	
	@Column(name="salary")
	private int employeeSalary;
	
	//@OneToOne
	//Passport passport =new Passport();
	

	//@OneToMany
	//List<Customer> cust= new ArrayList<Customer>();
	
	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(int employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	
	
}
