package com.company;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class SavingsAccountTest {
    public static void main(String[] args) {
        System.out.println("Trying to create spring container..");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("savings.xml");
        System.out.println("Spring container is ready... with savings.xml settings....");

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Account Number : ");
        int accNum = scan.nextInt();

        SavingsAccount savingsAccount = (SavingsAccount) ctx.getBean("mySavings");
        savingsAccount.setAccountNumber(accNum);
        double balance = savingsAccount.getAccountBalance();

        System.out.println("Balance "+balance);



    }

}
/*

SavingsAccount savingsAccount2 = (SavingsAccount) ctx.getBean("mySavings");
        SavingsAccount savingsAccount3 = (SavingsAccount) ctx.getBean("mySavings");

        System.out.println("savingsAccount1 :"+savingsAccount1.hashCode());
        System.out.println("savingsAccount2 :"+savingsAccount2.hashCode());
        System.out.println("savingsAccount3 :"+savingsAccount3.hashCode());

        savingsAccount1.setAccountNumber(123);
        savingsAccount1.setAccountHolderName("Arun");
        savingsAccount1.setAccountBalance(50000);

        savingsAccount2.setAccountNumber(554);
        savingsAccount2.setAccountHolderName("Ramji");
        savingsAccount2.setAccountBalance(60000);

        savingsAccount3.setAccountNumber(778);
        savingsAccount3.setAccountHolderName("Ashish");
        savingsAccount3.setAccountBalance(70000);

        System.out.println("savingsAccount1 : "+savingsAccount1);
        System.out.println("savingsAccount2 : "+savingsAccount2);
 */