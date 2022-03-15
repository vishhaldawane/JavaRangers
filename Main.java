package com.company;

public class Main {

    public static void main(String[] args) {

        Piston piston = new Piston("Digital Spark",2);
        Engine theEngine = new Engine(piston,"Diesel",1500);
	    Car myCar = new Car(theEngine,"Skoda"); // the Engine object is passed here as an argument
	    myCar.move();

	   // NepaliThali np = Hotel.getNepaliThali();

	    System.out.println("-----------");

        Piston piston2 = new Piston("Twin Spark",4);
        Engine theEngine2= new Engine(piston2,"Petrol",2000);
        Car myCar2 = new Car(theEngine2,"Merc");
        myCar2.move();

        System.out.println("-----------");

        Piston piston3 = new Piston("Digital Twin Spark",6);
        Engine theEngine3= new Engine(piston3,"CNG",4000);
        Car myCar3 = new Car(theEngine3,"Bugati");
        myCar3.move();

        System.out.println("--------------");

        VehicleFactory vehicleFactory = new VehicleFactory();
        Vehicle myVehicle = vehicleFactory.createVehicle("Maruti","Hybrid",3300,"DigiTwinSpark",6);
        myVehicle.move();


        //DI - Dependency Injection  | Inversion Of Control

    //    SpringFactory springFactory = new SpringFactory("abc.xml"); //abc.xml ->preconfigured objects -> Car, Engine, Piston using -> "Maruti" ,"Hybrid",3300,"DigiTwinSpark",6
    //    Vehicle myVehicle = springFactory.getBean("Maruti");
    //    myVehicle.move();
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
interface Vehicle //Vehicle.java
{
    void move(); //core functionality of any vehicle
}
class Car implements Vehicle //isA  Car.java
{
    String modelName;
    Engine theEngine; //hasA - just a reference...it is NULL, not an object creation

    Car(Engine theEngine, String modelName) {
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
        this.thePiston = thePiston;
        this.engineType = engineType;
        this.engineCapacity = engineCapacity;
    }
    void ignite() {
        thePiston.firePiston();
        System.out.println(engineType+"  Engine is ignited...with "+engineCapacity+" cc capacity");
    }
}

class Piston {//Piston.java
    String pistonType;
    int cylinders;

    Piston(String pistonType, int cylinders) {
        this.pistonType = pistonType;
        this.cylinders=cylinders;
    }

    void firePiston() {
        System.out.println(pistonType+" Piston is fired....with "+cylinders+ " cylinders");
    }
}


class VehicleFactory
{
    Vehicle createVehicle(String carModel, String engineType,int engineCapacity, String pistonType, int numberOfCylinders)
    {
        Piston thePiston = new Piston(pistonType,numberOfCylinders);
        Engine theEngine = new Engine(thePiston,engineType,engineCapacity);
        Car theCar = new Car(theEngine,carModel);
        return theCar;
    }
}