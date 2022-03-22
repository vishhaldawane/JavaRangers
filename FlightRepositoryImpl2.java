package com.company.myflights;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository("jack")  // spring with JDBC using Repository Implementation
public class FlightRepositoryImpl2 implements FlightRepository  {

    @PersistenceContext(unitName = "SpringJPA")
    EntityManager entityManager; //WITH ORM U NEED EntityManager

    public FlightRepositoryImpl2() {
        System.out.println("FlightRepositoryImpl2() Qualifier -> orm (jack)  way...");

    }
    @Autowired
    Flight flightObj;


    @Transactional
    public void insertFlight(Flight flightObj) {
        System.out.println("inserting flight...");
        entityManager.persist(flightObj);
        System.out.println("Row inserted...");

    }

    @Transactional
    public void updateFlight(Flight flightObj) {
        System.out.println("updating flight...");
        entityManager.merge(flightObj);
        System.out.println("Row updated...");

    }

    @Transactional
    public void deleteFlight(int flightNumber) {
        System.out.println("deleting flight....");
        Flight foundFlight  = entityManager.find(Flight.class, flightNumber);
        entityManager.remove(foundFlight);
        System.out.println("Flight deleted...");
    }


    public Flight selectFlight(int flightNumber) {
        System.out.println("selecting flight...");
        Flight flightFound = entityManager.find(Flight.class,flightNumber);
        return flightFound;
    }

    @Override
    public List<Flight> selectFlights() {
        System.out.println("selecting all flights...");

        List<Flight> allFlights = null;
        Query query = entityManager.createQuery("from Flight") ; // the POJO
        allFlights  = query.getResultList();
        return allFlights;
    }
}
