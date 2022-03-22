package com.company.myflights;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*

CREATE TABLE FLIGHTS
(
  FLIGHT_NUMBER INT PRIMARY KEY,
  FLIGHT_NAME VARCHAR(20),
  FLIGHT_SOURCE VARCHAR(20),
  FLIGHT_DESTINATION VARCHAR(20)
)

https://github.com/vishhaldawane/JavaRangers/blob/main/Flight.java
https://github.com/vishhaldawane/JavaRangers/blob/main/FlightRepository.java
https://github.com/vishhaldawane/JavaRangers/blob/main/FlightRepositoryImpl.java
https://github.com/vishhaldawane/JavaRangers/blob/main/FlightTest.java
https://github.com/vishhaldawane/JavaRangers/blob/main/myflights.xml

 */
@Component
@Entity
@Table(name="flights")
public class Flight { //1. POJO

    @Id
    @Column(name="flight_number")
    private int flightNumber;

    @Column(name="flight_name")
    private String flightName;

    @Column(name="flight_source")
    private String flightSource;

    @Column(name="flight_destination")
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
