package com.company.myflights;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="classpath:myflights.xml")
public class FlightTest {

    @Autowired
    FlightRepository flightRepository; // we are expecting from spring to get the object of this
                            //spring identifies the FlightRepositoryImpl
                            // as the implementation of FlightRepository

    @Autowired
    Flight flightObject; // we need not write -> new Flight()

    @Test
    public void addFlightTest() {
        flightObject.setFlightNumber(101);
        flightObject.setFlightName("American Airlines");
        flightObject.setFlightSource("Kathmandu");
        flightObject.setFlightDestination("New York");
        flightRepository.insertFlight(flightObject);
    }
    @Test
    public void addManyFlightsTest() {
        Flight flight1 = new Flight();
        Flight flight2 = new Flight();
        Flight flight3 = new Flight();

        flight1.setFlightNumber(102);
        flight1.setFlightName("Lufthansa");
        flight1.setFlightSource("Kathmandu");
        flight1.setFlightDestination("Germany");

        flight2.setFlightNumber(103);
        flight2.setFlightName("Nepal Airlines");
        flight2.setFlightSource("Kathmandu");
        flight2.setFlightDestination("New Jersey");

        flight3.setFlightNumber(104);
        flight3.setFlightName("Air India");
        flight3.setFlightSource("Mumbai");
        flight3.setFlightDestination("Washington");

        List<Flight> flightList = new ArrayList<Flight>();
        flightList.add(flight1);
        flightList.add(flight2);
        flightList.add(flight3);

        for (Flight theFlight: flightList) {
            flightRepository.insertFlight(theFlight);
        }
    }

    @Test
    public void modifyFlightTest() {
        flightObject.setFlightNumber(104);
        flightObject.setFlightName("Air India");
        flightObject.setFlightSource("Mumbai");
        flightObject.setFlightDestination("New Jesery");
        flightRepository.updateFlight(flightObject);
    }

    @Test
    public void deleteFlightTest() {
        flightRepository.deleteFlight(102);
    }

    @Test
    public void findFlightTest() {
        Flight flightFoundObj = flightRepository.selectFlight(101);
        System.out.println("Flight info  : "+flightFoundObj);
    }

    @Test
    public void findAllFlightsTest() {
        List<Flight> allFlights = flightRepository.selectFlights();
        for (Flight theFlight : allFlights) {
            System.out.println("Flight info : "+theFlight);
        }
    }

}
