package com.company.mycars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("carObj")
public class Car {

    @Autowired
    @Qualifier("engObj")
    Engine engine; //is it null? YES

    @Autowired
    @Qualifier("petEngObj")
    Engine engine2; //is it null? YES

    @Autowired
    @Qualifier("electEngObj")
    Engine engine3; //is it null? YES

    @Autowired
    @Qualifier("diesEngObj")
    Engine engine4; //is it null? YES

    Car() {
        System.out.println("Car()....");
    }
    public void startTheCar() {
        System.out.println("Starting the car...");
        engine.startTheEngine(); // if it is null, it would fail..
        engine2.startTheEngine();
        engine3.startTheEngine();
        engine4.startTheEngine();
    }
}
