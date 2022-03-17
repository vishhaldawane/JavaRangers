package com.company.mycars;

import org.springframework.stereotype.Component;

@Component("electEngObj")
public class ElectronicEngine extends Engine
{
    public ElectronicEngine() {
        System.out.println("ElectronicEngine()...");
        System.out.println("------------------------");
    }
    public void startTheEngine() {
        System.out.println("Starting the ElectronicEngine...");
    }
}
