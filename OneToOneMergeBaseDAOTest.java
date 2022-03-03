package com.company.onetoone;

import com.company.BaseDAOImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.logging.Level;


public class OneToOneMergeBaseDAOTest {
    public static void main(String[] args) {
        BaseDAOImpl baseDao = new BaseDAOImpl();
        Employee employee = baseDao.findAnyObject(Employee.class,103);//emp12 is the table for this Employee
        Passport passport = baseDao.findAnyObject(Passport.class,5111);

        passport.setEmployee(employee);//setting the Foreign key value in passport table's eno column
        //System.out.println("Passport :  "+passport);
        baseDao.mergeAnyObject(passport);
    }
}
