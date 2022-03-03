package com.company.onetoone.empdao;

import com.company.BaseDAOImpl;
import com.company.onetoone.Employee;

import java.util.List;

    //          Car                     Vehicle
public class EmployeeDAOImpl extends BaseDAOImpl implements EmployeeDAO {
    public void insertEmployee(Employee employee) { //startCar
        super.persistAnyObject(employee); // startVehicle
    } //C
    public Employee selectEmployee(int empno) {
        return super.findAnyObject(Employee.class,empno);
    } //R
    public List<Employee> selectEmployees() {
        return super.findAll("Employee");
    } //R
    public void updateEmployee(Employee employee) {
        super.mergeAnyObject(employee);
    } //U
    public void deleteEmployee(Employee employee) {
        super.removeAnyObject(employee);
    } //D
}
