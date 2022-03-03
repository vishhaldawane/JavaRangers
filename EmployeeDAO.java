package com.company.onetoone.empdao;

import com.company.onetoone.Employee;

import java.util.List;

public interface EmployeeDAO { //CRUD
     void insertEmployee(Employee employee); //C
     Employee selectEmployee(int empno); //R
     List<Employee> selectEmployees(); //R
     void updateEmployee(Employee employee); //U
     void deleteEmployee(Employee employee); //D

}
