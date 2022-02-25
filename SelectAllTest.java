package com.company;

import javax.persistence.*;
import java.util.List;

/*
Oracle - number for int values
         varchar2(20) for "String"

HSQLDB - int for int values
         varchar(20) for "String"

 MSSQL - int for int values
         nvarchar(20) for "String"
 */
public class SelectAllTest { //@OneToMany - One Dept -> 3 emps -> 5 address - 3 food - 1 passport
//GirCow theCow = FarmHouse.getCirCow("brown"); -- cow_info.xml
    //Milk milk = theCow.getMilk();

    //milk.checkTemperature();
        //milk.coagulate(); //utilizing the milk -
    //milk.completeCoagulation();

    public static void main(String[] args) {
        EntityManagerFactory emf =
                    Persistence.createEntityManagerFactory("MyJPA"); //persistence.xml is read here
            System.out.println("Entity Manager Factory : "+emf);//same like theCow

        EntityManager em = emf.createEntityManager(); // same like milk

        Query query = em.createQuery("from Department"); // observe this query, its is not a standard SQL query, it is HQL/JPQL

        List<Department> deptList= query.getResultList();//extract all the rows

        for(Department dept  : deptList) {
            System.out.println("DEPT number   : "+dept.getDepartmentNumber());
            System.out.println("DEPT name     : "+dept.getDepartmentName());
            System.out.println("DEPT location : "+dept.getDepartmentLocation());
            System.out.println("---------------");
        }
    }
}

/*
                HIBERNATE IS AN ORM TOOL TO EASE YOUR DATABASE ACTIVITIES


                HIBERNATE - TO HIDE  -- FROGS


                DATABASE
                |
                ORM <-- ORM IS AN ABSTRACTION LAYER FOR US - TO HIDE ALL THE JDBC "BOILER PLATE" CODE
                |
                JAVA CODE

        ORM - Object                Relation        Mapping
                |                   |                |
               java object      database table     association
               |                    |
               Department           mydept
               |
               departmentNumber     deptno
               departmentName       deptname
               departmentLocation   deptloc


       Department dept1 = new Department();
       Department dept2 = new Department();

       dept1.setDepartmentNumber(10);
       dept2.setDepartmentNumber(20);

       dept1.setDepartmentName("ACCOUNTS");
       dept2.setDepartmentName("ACCOUNTS");

       dept1.setDepartmentLocation("NY");
       dept2.setDepartmentLocation("NJ");




       MYDEPT  - one dept can have many employees - ONE TO MANY
       -------
       deptno   deptname    deptloc
       10       ACCOUNTS    NY
       20       SALES       NJ



       Employee emp1 = new Employee();
       Employee emp2 = new Employee();
       Employee emp3 = new Employee();
       Employee emp4 = new Employee();
       Employee emp5 = new Employee();

       MYEMP - MANY EMPLOYEES CAN HAVE ONE DEPT ----  MANY TO ONE
       ------
       empno    ename   job         salary      deptno
       1234     jack    salesman    5000        20
       1235     john    salesman    5600        20
       1236     jacky   salesman    5700        20

       2234     sam     clerk       2000        10
       3235     ram     clerk       3600        10


       ADDRESS  - one employee can have many addresses - ONE TO MANY
       --------
        area    city        state       country pin     eno
        WA      Kathmandu   Kathmandu    Nepal   450    1234
        EA      NY          NY           US      567    1234


        PASSPORT <--- one employee has one passport -- ONE TO ONE
        --------
        passportid      issuedon     issuedby        expiryon       eno
        123456677       10-Aug-2018  NepalGovt       10-Aug-2028    1234
        123456666       10-Aug-2018  NepalGovt       10-Aug-2028    3235

IF THE QUERY IS - TO FIND OUT THE EMPLOYEE NAMES WHO ARE WORKING IN NEW JERSEY


            FOOD
            ----------
            FOODID  FOODDESCRIP
            101     PIZZA
            102     BURGER


            FOOD_ORDER_BY_EMP       --  MANY TO MANY ----- MANY EMP CAN ORDER MANY FOOD

            PK      FK      FK
            ORDID   FOODID  EMPID       ORDDATE
            1       101     1234        10-AUG-2021
            2       101     3235        10-AUG-2021
            3       101     1234        10-SEP-2021
            4       102     3235
            5       102     1234


            HIBERNATE = ORM FRAMEWORK

            INSERT INTO DEPT (???)
            INSERT INTO EMP (???????)
            INSERT INTO FOOD (????)
            INSERT INTO ADDRESS (?????????);

            SELECT * FROM DEPT
            SELECT * FROM EMP ..


            UPDATE EMP SET ........
            UPDATE ADDRESS SET .......

            DELETE ..


HSQLDB.JAR

    - DOWNLOAD  HIBERNATE LIBRARY

    Department dept = new Department();


Serialization = storing the java object on the FILE - ObjectOutputStream/ObjectInputStream

Persistence   = storing the java object on the database table in the form of a ROW

                                JPA
                                |
                         Java Persistence API

   1      Persistence
   2      EntityManagerFactory - assist to connect to the database - we just have to configure the settings for
                            driver, url, username, password


   3     EntityManager - assist to store the object, retrieve the object, update, delete,
         EntityTransaction - commit/rollback


    1    FarmHouse - to maintain - electricity for water pump, storage... for grass...
    2    GirCow - feed Grass, Water, Fodder....
    3    Milk
             from milk - we can make cheese, paneer, butter, buttermilk, milk shake, ghee, curd...

                    all milk based products


BASIC structure of your project



xml - extensible markup language

love.txt
--------
hi Reeta
I love you

lets meet for a coffee

I miss you





regs
Vishhal
----------

love.xml
-------------
<?xml...>

<love-letter>
 <salutation> Hi Reeta </salutation>

 <main-message>
    I miss you
 </main-message>

 <theme>
    i love you
 </them>

 <meet>
    lets meet for a coffee
 </meet>

 <closure>
    always yours....
    Vishhal
 </closure>

</love-letter>

Developer   <----- META-INF/persistence.xml------> ORM Framework
                        YourProject
                            |
                   -------------------------------------------------------------
                   |                    |               |               |
               1. libraries         3   Pojo          2  META-INF      4  Main
                 |                      |               |                   Persistence, EntityManagerFactory
          already downloaded        Department          persistence.xml     EntityManager, EntityTransaction
          from hibernate.org        Employee            |                   persist();find();merge();delete()
                                    Address           configure your driver, url, username, password
                                    Passport
                                    Car
                                    Food
                   (configure these pojos with proper annotations )

                   @ <-- annotation begins with this symbol


.jar file = collection to hold multiple .class files...


1) to create your own jar file
        jar -cvf flowers.jar  Rose.class Lotus.class Lily.class

    -c means create a jar file
    -v  verbose - progress to see
    -f  file name to specify


2) to see the content of your jar file
    jar -tvf flowers.jar

    -t means table of contents

 3) to extract all the classes from the jar file

    jar -xvf flowers.jar

 4) type ls from mac os
        or
        dir from windows os to see the files of that folder



                   @OneToOne

                   @OneToMany

                   @ManyToMany

                   @Id <-- primary key

                   @JoinColumn <-- foreign key

                   @Column



                   Boy1             Boy2
                   |                |
                   Cap              Cap(NY)
                   Face             Face
                   sunglasses       sunglasses (RayBan)
                   TShirt           TShirt <- ANZ
                   Belt             Belt<- Woodland
                   Jean             Jean<-Levis
                   Shoes            Shoes<-Sketchers|Puma|Adidas












 */
