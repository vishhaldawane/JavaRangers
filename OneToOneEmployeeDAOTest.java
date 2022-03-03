package com.company.onetoone;

import com.company.BaseDAOImpl;
import com.company.onetoone.empdao.EmployeeDAOImpl;

import java.time.LocalDate;
import java.util.List;

public class OneToOneEmployeeDAOTest {
    public static void main(String[] args) {

       /* Employee employee = new Employee();
            employee.setEmployeeNumber(105);
            employee.setEmployeeName("Jack");
            employee.setEmployeeSalary(8300);
        System.out.println("Employee :  "+employee);

        EmployeeDAOImpl empDao = new EmployeeDAOImpl();
        empDao.insertEmployee(employee);*/

        EmployeeDAOImpl empDao = new EmployeeDAOImpl();

        List<Employee> allEmps = empDao.selectEmployees();
        for (Employee theEmp: allEmps) { //let me be on mute for 1 mnt
            System.out.println("Employee Number "+theEmp.getEmployeeNumber());
            System.out.println("Employee Number "+theEmp.getEmployeeName());
            System.out.println("Employee Number "+theEmp.getEmployeeSalary());
            System.out.println("-----------------");
        }

    }
}
