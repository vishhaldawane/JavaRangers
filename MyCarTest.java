package com.company.mycars;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyCarTest {
    public static void main(String[] args) {
        System.out.println("Trying to get the container for mycars...");
        ApplicationContext container = new ClassPathXmlApplicationContext("mycars.xml");
        System.out.println("Got the Spring container...");
        Car myCar = (Car) container.getBean("carObj");
        myCar.startTheCar();
    }
}
