package com.java.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 
  
  DEPT8
  deptno	dname		loc   <-- and we dont want emp's fk here
  10		IT			NY	
  20		Test		NJ
  

dept_emp <-- we dont want this way
  deptno	empno
  10		101
  10		102
  10		103
  
  EMPLOYEE8					FK <--we want fk here 
  empno	empname	empsal	deptno
  101	jack	5500		10
  102	jane	6500		10
  103	jill	7500		10
  
  104	robert	6866		20
  105	smith	6778		20
  
  
 */
@Entity //mandatory
@Table(name="DEPT10") // this is the table name mapped with the Department class
public class Department { //1. POJO/entity is done
	
	@Id //mandatory  - to declare the column name below is a primary key
	@Column(name="deptno") //physical/real column name of the table
	private int departmentNumber;
	
	@Column(name="dname")
	private String departmentName;
	
	@Column(name="loc")
	private String departmentLocation;
	
	//for one to one - the default fetch policy is EAGER
	//for one to many - the default fetch policy is LAZY
	
	//Defines the set of cascadable operations that are propagated to the
	//associated entity. The value cascade=ALL is equivalent to 
	//cascade={PERSIST, MERGE, REMOVE, REFRESH, DETACH}.
	@OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "dept") //one Department has Many Employees
	private Set<Employee> empSet = new HashSet<Employee>();
	
	
	
	//java.time.*
	//LocalDate dateOfJoining,   birthdate, hiredate, shipdate, orderdate....
	//LocalDateTime
	
	public Set<Employee> getEmpSet() {
		return empSet;
	}
	public void setEmpSet(Set<Employee> empSet) {
		this.empSet = empSet;
	}
	
	public int getDepartmentNumber() {
		return departmentNumber;
	}
	public void setDepartmentNumber(int departmentNumber) {
		this.departmentNumber = departmentNumber;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentLocation() {
		return departmentLocation;
	}
	public void setDepartmentLocation(String departmentLocation) {
		this.departmentLocation = departmentLocation;
	}
	
	
	
}
