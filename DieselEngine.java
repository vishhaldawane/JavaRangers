package com.company.mycars;

import org.springframework.stereotype.Component;

@Component("diesEngObj")
public class DieselEngine extends Engine
{

    public DieselEngine() {
        System.out.println("DieselEngine()...");
        System.out.println("------------------------");
    }
    public void startTheEngine() {
        System.out.println("Starting the DieselEngine...");
    }
}
