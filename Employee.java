package com.company.onetoone;

import javax.persistence.*;

@Entity
@Table(name="emp12")
public class Employee {

    @Id
    @Column(name="empno")
    int employeeNumber;

    @Column(name="ename")
    String employeeName;

    @Column(name="sal")
    float employeeSalary;

    //4th column below, is not a real column
    //it is just an association mapping
    @OneToOne(mappedBy = "employee")
    Passport passport;

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

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }
}
