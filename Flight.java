package com.company;

import org.springframework.stereotype.Component;

@Component("fliObj")
public class Flight {

    String flightNumber;
    String flightName;
    String flightSource;
    String flightDestination;

    Flight() {
        System.out.println("Flight constructor....");
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getFlightSource() {
        return flightSource;
    }

    public void setFlightSource(String flightSource) {
        this.flightSource = flightSource;
    }

    public String getFlightDestination() {
        return flightDestination;
    }

    public void setFlightDestination(String flightDestination) {
        this.flightDestination = flightDestination;
    }
}


@Component("fightFli")
class FighterFlight {
    public FighterFlight() {
        System.out.println("FighterFlight()  ctor...");
    }
}

@Component("commFli")
class CommercialFlight {
    public CommercialFlight() {
        System.out.println("CommercialFlight()  ctor...");
    }
}

@Component("cargFli")
class CargoFlight{
    public CargoFlight() {
        System.out.println("CargoFlight()  ctor...");
    }
}
