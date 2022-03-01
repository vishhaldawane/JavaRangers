package com.company.onetomany;

import com.company.onetoone.Passport;

import javax.persistence.*;

@Entity
@Table(name="EMP13")
public class Employee2 {

    @Id
    @Column(name="empno")
    int employeeNumber;

    @Column(name="ename")
    String employeeName;

    @Column(name="sal")
    float employeeSalary;

    @ManyToOne
    @JoinColumn(name="eno")
    Department department;

    public Employee2() {
        System.out.println("Employee2() ctor....");
    }
    public Employee2(int employeeNumber, String employeeName, float employeeSalary, Department department) {
        this.employeeNumber = employeeNumber;
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.department = department;
    }

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

    public float getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(float employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
