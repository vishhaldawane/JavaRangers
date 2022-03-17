package com.company.mycars;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="classpath:mycars.xml")
public class MyCarTest2 {
    @Autowired @Qualifier("carObj")
    Car myCar; // Car myCar = (Car) container.getBean("carObj");
    @Test
    public void testCar() {
        myCar.startTheCar();
    }
}
