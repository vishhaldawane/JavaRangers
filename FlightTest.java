package com.company;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FlightTest {
    public static void main(String[] args) {


//        DONT KNOW <-- DONT KNOW

        System.out.println("Trying to get the container for flights...");
        ApplicationContext container = new ClassPathXmlApplicationContext("flights.xml");
        System.out.println("Got the Spring container...");



    }
}
