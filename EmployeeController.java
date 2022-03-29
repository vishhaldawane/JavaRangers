package com.java.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.entity.Employee;

@RestController

@RequestMapping("/employees")
public class EmployeeController {
	

	List<Employee> empList  = new ArrayList<Employee>();
	
	public EmployeeController() {
		
		System.out.println("EmployeeController() ctor....");
		Employee emp1 = new Employee(); //dummy object - not from the DB/repo
		emp1.setEmployeeNumber(101);
		emp1.setEmployeeName("Ashish");
		emp1.setEmployeeSalary(12300);
		
		Employee emp2 = new Employee(); //dummy object - not from the DB/repo
		emp2.setEmployeeNumber(102);
		emp2.setEmployeeName("Arun");
		emp2.setEmployeeSalary(22300);
		
		Employee emp3 = new Employee(); //dummy object - not from the DB/repo
		emp3.setEmployeeNumber(103);
		emp3.setEmployeeName("Ramji");
		emp3.setEmployeeSalary(32300);
		
		Employee emp4 = new Employee(); //dummy object - not from the DB/repo
		emp4.setEmployeeNumber(104);
		emp4.setEmployeeName("Piyush");
		emp4.setEmployeeSalary(36300);
		
		
		Employee emp5 = new Employee(); //dummy object - not from the DB/repo
		emp5.setEmployeeNumber(105);
		emp5.setEmployeeName("Meelan");
		emp5.setEmployeeSalary(62300);
		
		
		Employee emp6 = new Employee(); //dummy object - not from the DB/repo
		emp6.setEmployeeNumber(106);
		emp6.setEmployeeName("Saral");
		emp6.setEmployeeSalary(82300);
		
		
		Employee emp7 = new Employee(); //dummy object - not from the DB/repo
		emp7.setEmployeeNumber(107);
		emp7.setEmployeeName("Jagdish");
		emp7.setEmployeeSalary(82300);
		
		
		Employee emp8 = new Employee(); //dummy object - not from the DB/repo
		emp8.setEmployeeNumber(108);
		emp8.setEmployeeName("Sudin");
		emp8.setEmployeeSalary(92300);
		
		
		Employee emp9 = new Employee(); //dummy object - not from the DB/repo
		emp9.setEmployeeNumber(109);
		emp9.setEmployeeName("Suraj");
		emp9.setEmployeeSalary(882800);
		
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);
		empList.add(emp4);
		empList.add(emp5);
		empList.add(emp6);
		empList.add(emp7);
		empList.add(emp8);
		empList.add(emp9);
	
	}
	
//	GET     http://localhost:8080/employees/getEmp/101 <-- getting a single object

	
	@PostMapping
	@RequestMapping("/addEmp")
	public String addEmployee(@RequestBody Employee empObj) {
		System.out.println("/addEmp");
		
		
		boolean employeeAlreadyPresent=false;

		for (int i = 0; i < empList.size(); i++) {
			Employee tempEmp = empList.get(i);
			if(tempEmp.getEmployeeNumber() == empObj.getEmployeeNumber()) {
				employeeAlreadyPresent=true;
				break;
			}
		}
		if(employeeAlreadyPresent==true) {
			return "Employee already exists : employee number : "+empObj.getEmployeeNumber();
		}
		else { 
			
			empList.add(empObj);
			return "Employee object added successfully.."+empObj.getEmployeeNumber();		
		}
		
	}
	
	@PutMapping
	@RequestMapping("/updateEmp")
	public String updateEmployee(@RequestBody Employee empObj) {
		System.out.println("/updateEmp");
		
		
		boolean employeeFound=false;

		for (int i = 0; i < empList.size(); i++) {
			Employee tempEmp = empList.get(i);
			if(tempEmp.getEmployeeNumber() == empObj.getEmployeeNumber()) {
				employeeFound=true;
				empList.remove(i);
				empList.add(i, empObj);
				break;
			}
		}
		if(employeeFound==true) {
			return "Employee modified : employee number : "+empObj.getEmployeeNumber();
		}
		else { 
			return "Employee NOT found : employee number : "+empObj.getEmployeeNumber();		
		}
		
	}
	
	@GetMapping
	@RequestMapping("/getEmp/{eno}")
	public Employee getEmployee(@PathVariable("eno") int x ) {
		System.out.println("/getEmp");
		
		Employee foundEmp = null;
		
		for(Employee tempEmp : empList) {
			if(tempEmp.getEmployeeNumber() == x) {
				foundEmp = tempEmp;
				break;
			}
		}
		return foundEmp;
	}

	
	@GetMapping
	@RequestMapping("/deleteEmp/{eno}")
	public String deleteEmployee(@PathVariable("eno") int x ) {
		System.out.println("/deleteEmp");
		
		boolean employeeDeleted=false;

		for (int i = 0; i < empList.size(); i++) {
			Employee tempEmp = empList.get(i);
			if(tempEmp.getEmployeeNumber() == x) {
				empList.remove(i);
				employeeDeleted=true;
				break;
			}
		}
		if(employeeDeleted==true) {
			return "Employee deleted : employee number : "+x;
		}
		else { 
			return "Employee NOT found : employee number : "+x;
		}
	}

	
	@GetMapping
	@RequestMapping("/getEmps")
	public List<Employee> getEmployees() {
		System.out.println("/getEmps");
		return empList;
	}

}

/*
 
  
  
POST    http://localhost:8080/employees/addEmp/ <-- body of the employee obj
PUT     http://localhost:8080/employees/updateEmp/ <--body of the employee obj
  
DELETE  http://localhost:8080/employees/deleteEmp/101 <-- delete
  
GET     http://localhost:8080/employees/getEmp/101 <-- getting a single object
  
GET     http://localhost:8080/employees/getEmps <-- getting an array list 
  
  
 */
