package com.company;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
//Annotation = extra information in a standard way AGAINST comments


//Entity is a java class, managed by a primary key (unique+nn)

@Entity //mandatory
@Table(name="DEPT_FC") // this is the table name mapped with the Department class
public class Department { //1. POJO/entity is done

    @Id //mandatory  - to declare the column name below is a primary key
    @Column(name = "deptno") //physical/real column name of the table
    private int departmentNumber;

    @Column(name = "deptname")
    private String departmentName;

    @Column(name = "deptloc")
    private String departmentLocation;

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
