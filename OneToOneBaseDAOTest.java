package com.company.onetoone;

import com.company.BaseDAOImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class OneToOneBaseDAOTest {
    public static void main(String[] args) {

        Employee employee = new Employee();
            employee.setEmployeeNumber(104);
            employee.setEmployeeName("Jack");
            employee.setEmployeeSalary(8800);
        System.out.println("Employee :  "+employee);

        Passport passport = new Passport();
            passport.setPassportNumber(5222);
            passport.setPassportIssuedBy("Nepal Govt.");
            passport.setPassportIssuedOn(LocalDate.of(2012,7,25));
            passport.setPassportExpiryOn(LocalDate.of(2022,7,25));
            passport.setEmployee(employee);//setting the Foreign key value in passport table's eno column
        System.out.println("Passport :  "+passport);


        BaseDAOImpl baseDao = new BaseDAOImpl();
        baseDao.persistAnyObject(employee);
        baseDao.persistAnyObject(passport);



    }
}
