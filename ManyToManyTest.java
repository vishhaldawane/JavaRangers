package com.company.manytomany;

import com.company.onetomany.Department;
import com.company.onetomany.Employee2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class ManyToManyTest {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyJPA"); //persistence.xml is read here
        System.out.println("Entity Manager Factory : "+emf);//same like theCow

        EntityManager em = emf.createEntityManager(); // same like milk
        System.out.println("Entity manager "+em);

        EntityTransaction et = em.getTransaction();
        System.out.println("Entity transaction: "+et);

        Customer cust6 = new Customer();
        cust6.setCustomerId(6);
        cust6.setCustomerName("Vishhal");
        cust6.setCustomerEmailAddress("vishhal@gmail.com");


        Subscription sub3 = new Subscription();
        sub3.setSubscriptionId(333);
        sub3.setSubscriptionType("Spiritual Books");
        sub3.setSubscriptionDuration("12 months");


        et.begin();
            em.persist(cust6);
            em.persist(sub3);

        et.commit();


    }
}
