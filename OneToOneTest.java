package com.company.onetoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;

/*

    One Employee <--> One Passport
    One Passport <--> One Employee

    Employee "hasA" Passport

    Passport belongs to an Employee

    Employee-A
    ----------
    pk
    empno   ename   sal
    101     Jack    5000
    102     Jane    6000
    103     Joby    7000

    Passport -B
    ----------
    pk                                                      fk
    passportnumber    issuedby    issuedon    expiryon      eno
    1234            Govt.Ind    10-08-2019  10-08-2029      105
    5234            Govt.Ind    20-08-2019  20-08-2029      102
    7234            Govt.Ind    30-08-2019  30-08-2029      103

CREATE TABLE EMP11
(
  EMPNO INT PRIMARY KEY,
  ENAME VARCHAR(20),
  SAL INT
)

INSERT INTO EMP11 VALUES (101,'JACK',5000);
INSERT INTO EMP11 VALUES (102,'JANE',6000);
INSERT INTO EMP11 VALUES (103,'JULIE',7000);

CREATE TABLE PASSPORT11
(
 PASSPORTNUMBER INT PRIMARY KEY,
 ISSUEDBY  VARCHAR(20),
 ISSUEDON  DATE,
 EXPIRYON DATE,
 ENO INT REFERENCES EMP11(EMPNO) unique,

)


INSERT INTO PASSPORT11 VALUES (1234,'GOVT.OF INDIA','2018-08-20','2028-08-20',101);
INSERT INTO PASSPORT11 VALUES (4234,'GOVT.OF INDIA','2019-08-20','2029-08-20',102);
INSERT INTO PASSPORT11 VALUES (8934,'GOVT.OF INDIA','2019-08-22','2029-08-22',103);
INSERT INTO PASSPORT11 VALUES (1234,'GOVT.OF INDIA','2018-08-20','2028-08-20',null);




 */
public class OneToOneTest {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("MyJPA"); //persistence.xml is read here
        System.out.println("Entity Manager Factory : "+emf);//same like theCow

        EntityManager em = emf.createEntityManager(); // same like milk
        System.out.println("Entity manager "+em);

        EntityTransaction et = em.getTransaction();
        System.out.println("Entity transaction: "+et);

        Employee employee = new Employee();

       //object crawler/spider

            employee.setEmployeeNumber(102);
            employee.setEmployeeName("Arun");
            employee.setEmployeeSalary(6000);
        System.out.println("Employee :  "+employee);

        Passport passport = new Passport();
            passport.setPassportNumber(5534);
            passport.setPassportIssuedBy("Nepal Govt.");
            passport.setPassportIssuedOn(LocalDate.of(2015,7,25));
            passport.setPassportExpiryOn(LocalDate.of(2025,7,25));
            //passport.setEmployee(employee);//setting the Foreign key value in passport table's eno column
        System.out.println("Passport :  "+passport);


        et.begin();
            em.persist(employee);
            System.out.println("Employee stored...");

            em.persist(passport);
            System.out.println("Passport stored...");
        et.commit();


    }
}
