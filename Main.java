package com.company;

import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        //SavingsAccount savingsAccount = new SavingsAccount();

        System.out.println("Trying to create spring container..");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("abc.xml");
        System.out.println("Spring container is ready....");

        Car theCar = (Car) ctx.getBean("myCar");
        theCar.move();

    }
}
/*
baking a cake for 3 hours    vs      cake shop


declarative programming


DI

abc.xml --> java objects described in XML style
<beans>

    <bean id="Maruti" >
        <constructor-arg ref="theEngine"> ... Hybrid
    </bean>

    <bean id="theEngine" ref="thePiston">
        <>
    </bean>

    <bean id="thePiston">
        <>
    </bean>


</beans>



 */

class SavingsAccount
{
    SavingsAccount() {
        System.out.println("SavingsAccount() ctor....");
    }
    void withdraw() {
        System.out.println("Withdrawing....");
    }
}
interface Vehicle //Vehicle.java
{
    void move(); //core functionality of any vehicle
}

class Car implements Vehicle //isA  Car.java
{
    String modelName;
    Engine theEngine; //hasA - just a reference...it is NULL, not an object creation

    Car(Engine theEngine, String modelName) {
        System.out.println("Car(Engine,String) constructed...");
        this.theEngine = theEngine; // it is initialized...
        this.modelName = modelName;
    }

    public void move() {
        theEngine.ignite();
        System.out.println(modelName+" Car is moving....");

    }
}

class Engine //Engine.java
{
    Piston thePiston; //the null
    String engineType;
    int engineCapacity;

    Engine(Piston thePiston, String engineType, int engineCapacity) {
        System.out.println("Engine(Piston,String,int) constructed...");
        this.thePiston = thePiston;
        this.engineType = engineType;
        this.engineCapacity = engineCapacity;
    }
    void ignite() {
        thePiston.firePiston();
        System.out.println(engineType+"  Engine is ignited...with "+engineCapacity+" cc capacity");
    }
}

//intellij ultimate

class Piston {//Piston.java
    String pistonType;
    int cylinders;

//    Piston() {
//        System.out.println("Piston()...no argument ctor...");
//    }

//    Piston(String pistonType) {
//        System.out.println("Piston(String)... arguments ctor...");
//        this.pistonType = pistonType;
//
//    }

    Piston(String pistonType, int cylinders) {
        System.out.println("Piston(String,int)... constructed......");
        this.pistonType = pistonType;
        this.cylinders=cylinders;
    }

    void firePiston() {
        System.out.println(pistonType+" Piston is fired....with "+cylinders+ " cylinders");
    }
}

/*
class VehicleFactory
{
    Vehicle createVehicle(String carModel, String engineType,int engineCapacity, String pistonType, int numberOfCylinders)
    {
        Piston thePiston = new Piston(pistonType,numberOfCylinders);
        Engine theEngine = new Engine(thePiston,engineType,engineCapacity);
        Car theCar = new Car(theEngine,carModel);
        return theCar;
    }
}*/