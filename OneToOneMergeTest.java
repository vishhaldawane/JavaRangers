package com.company.onetoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class OneToOneMergeTest {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyJPA"); //persistence.xml is read here
        System.out.println("Entity Manager Factory : "+emf);//same like theCow

        EntityManager em = emf.createEntityManager(); // same like milk
        System.out.println("Entity manager "+em);

        EntityTransaction et = em.getTransaction();
        System.out.println("Entity transaction: "+et);

        Employee employee = em.find(Employee.class,102);//emp12 is the table for this Employee
        Passport passport = em.find(Passport.class,5534);

            passport.setEmployee(employee);//setting the Foreign key value in passport table's eno column
        System.out.println("Passport :  "+passport);

        et.begin();
            em.merge(passport);
            System.out.println("Passport modified...");
        et.commit();


    }
}
