package com.company.mycars;

import org.springframework.stereotype.Component;

@Component("engObj")
public class Engine {
    public Engine() {
        System.out.println("Engine()...");
    }
    public void startTheEngine() {
        System.out.println("Starting the engine...");
    }
}
