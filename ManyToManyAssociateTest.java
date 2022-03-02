package com.company.manytomany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class ManyToManyAssociateTest {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyJPA"); //persistence.xml is read here
        System.out.println("Entity Manager Factory : "+emf);//same like theCow

        EntityManager em = emf.createEntityManager(); // same like milk
        System.out.println("Entity manager "+em);

        EntityTransaction et = em.getTransaction();
        System.out.println("Entity transaction: "+et);

        Customer cust1 = em.find(Customer.class,3);
        Customer cust2 = em.find(Customer.class,6); // Junit Test cases  @Test annotation
      /*  Customer cust3 = em.find(Customer.class,3);
        Customer cust4 = em.find(Customer.class,4);
        Customer cust5 = em.find(Customer.class,5);*/


        Subscription sub1 = em.find(Subscription.class,333);
      //  Subscription sub2 = em.find(Subscription.class,222);

        cust1.getSubscriptions().add(sub1);
        cust2.getSubscriptions().add(sub1);

        /* cust2.getSubscriptions().add(sub1);
        cust2.getSubscriptions().add(sub2);

       cust2.getSubscriptions().add(sub1);
        cust2.getSubscriptions().add(sub2);

        cust3.getSubscriptions().add(sub1);
        cust3.getSubscriptions().add(sub2);

        cust4.getSubscriptions().add(sub1);
        cust4.getSubscriptions().add(sub2);

        cust5.getSubscriptions().add(sub1);
        cust5.getSubscriptions().add(sub2);
*/


        et.begin();

            em.merge(cust1);
            em.merge(cust2);
          //  em.merge(cust4);
      //      em.merge(cust5);


        et.commit();


    }
}
