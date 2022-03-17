package com.company.mycars;

import org.springframework.stereotype.Component;

@Component("petEngObj")
public class PetrolEngine extends Engine
{
    public PetrolEngine() {
      // super();
        System.out.println("PetrolEngine()...");
        System.out.println("------------------------");
    }
    public void startTheEngine() {
        System.out.println("Starting the PetrolEngine...");
    }
}
