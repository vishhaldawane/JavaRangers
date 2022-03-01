package com.company.onetomany;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//Annotation = extra information in a standard way AGAINST comments


//Entity is a java class, managed by a primary key (unique+nn)

/*

OneToMany
 |      |
 dept  emp

DEPT
    deptno      dname       loc
    10          IT          NY
    20          Test        NJ
    30          Sales         ND

ManyToOne
|       |
emp     dept


EMP
    empno   ename   job     sal     dno
    101     jack    clerk   ..      10
    102     jane    manager ..      10
    103     jill    manager ..      20
    104     Amar    clerk   ..      20

    105     Ajay    salesman .      30
    106     Mahmood salesman ..     30
    107     Zubair  salesman ...    30

    108     Ram     ....            10
    109     Peter     ....          20

 */
@Entity //mandatory
@Table(name="DEPT13") // this is the table name mapped with the Department class
public class Department { //1. POJO/entity is done

    @Id //mandatory  - to declare the column name below is a primary key
    @Column(name = "deptno") //physical/real column name of the table
    private int departmentNumber;

    @Column(name = "deptname")
    private String departmentName;

    @Column(name = "deptloc")
    private String departmentLocation;

    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Set<Employee2>  employees= new HashSet<Employee2>();

    public Department() {
        System.out.println("Department() ctor...");
    }

    public Department(int departmentNumber, String departmentName, String departmentLocation) {
        this.departmentNumber = departmentNumber;
        this.departmentName = departmentName;
        this.departmentLocation = departmentLocation;
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

    public Set<Employee2> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee2> employees) {
        this.employees = employees;
    }
}
