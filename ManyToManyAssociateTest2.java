package com.company.manytomany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Set;


public class ManyToManyAssociateTest2 {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyJPA"); //persistence.xml is read here
        System.out.println("Entity Manager Factory : "+emf);//same like theCow

        EntityManager em = emf.createEntityManager(); // same like milk
        System.out.println("Entity manager "+em);

        Subscription sub1 = em.find(Subscription.class,333);
        System.out.println("Subscription Type     : "+sub1.getSubscriptionType());
        System.out.println("Subscription Duration : "+sub1.getSubscriptionDuration());

        System.out.println("--> customers for the above subscription is as below...");
        Set<Customer> customers = sub1.getCustomers();
        for(Customer cust : customers) {
            System.out.println("Customer id : "+cust.getCustomerId());
            System.out.println("Customer name : "+cust.getCustomerName());
            System.out.println("Customer email : "+cust.getCustomerEmailAddress());
            System.out.println("------------------");

        }

    }
}
