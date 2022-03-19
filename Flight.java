package com.company.myflights;

import org.springframework.stereotype.Component;

/*

CREATE TABLE FLIGHTS
(
  FLIGHT_NUMBER INT PRIMARY KEY,
  FLIGHT_NAME VARCHAR(20),
  FLIGHT_SOURCE VARCHAR(20),
  FLIGHT_DESTINATION VARCHAR(20)
)

 */
@Component
public class Flight { //1. POJO
    private int flightNumber;
    private String flightName;
    private String flightSource;
    private String flightDestination;

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
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

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber=" + flightNumber +
                ", flightName='" + flightName + '\'' +
                ", flightSource='" + flightSource + '\'' +
                ", flightDestination='" + flightDestination + '\'' +
                '}';
    }
}
