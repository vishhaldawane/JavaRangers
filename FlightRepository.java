package com.company.myflights;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // it is a shade / extension of @Component
public interface FlightRepository { //
    public void insertFlight(Flight flightObj);
    public void updateFlight(Flight flightObj);
    public void deleteFlight(int flightNumber);
    public Flight selectFlight(int flightNumber);
    public List<Flight> selectFlights();
}
