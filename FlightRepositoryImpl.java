package com.company.myflights;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository  // spring with JDBC using Repository Implementation
public class FlightRepositoryImpl implements FlightRepository {

    //@Autowired
    //@Qualifier("myds") //expecting spring to find the object of DataSource implementation, ie DriverManagerDataSource's object
    DataSource dataSource; //WITH ORM U NEED EntityManager

    @Autowired
    Flight flightObj;

    Connection conn;

    @Autowired
    FlightRepositoryImpl(@Qualifier("myds") DataSource dataSource) {
        this.dataSource = dataSource;
        try {
            this.conn = dataSource.getConnection();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void insertFlight(Flight flightObj) {
        System.out.println("inserting flight...");
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("insert into flights values (?,?,?,?)");
            preparedStatement.setInt(1,flightObj.getFlightNumber());
            preparedStatement.setString(2,flightObj.getFlightName());
            preparedStatement.setString(3,flightObj.getFlightSource());
            preparedStatement.setString(4,flightObj.getFlightDestination());
            int rows = preparedStatement.executeUpdate();
            System.out.println("Row inserted..."+rows);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void updateFlight(Flight flightObj) {
        System.out.println("updating flight...");
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("update flights set flight_name=?, flight_source=?, flight_destination=? where flight_number=?");


            preparedStatement.setString(1,flightObj.getFlightName());
            preparedStatement.setString(2,flightObj.getFlightSource());
            preparedStatement.setString(3,flightObj.getFlightDestination());

            preparedStatement.setInt(4,flightObj.getFlightNumber()); //where clause

            int rows = preparedStatement.executeUpdate();
            System.out.println("Row updated..."+rows);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void deleteFlight(int flightNumber) {
        System.out.println("deleting flight....");
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from flights where flight_number="+flightNumber);
            if(resultSet.next()) {
                PreparedStatement preparedStatement = conn.prepareStatement("delete from flights where flight_number=?");
                preparedStatement.setInt(1, flightNumber); //where clause
                int rows = preparedStatement.executeUpdate();
                System.out.println("Row deleted..." + rows);
            }
            else {
                throw new RuntimeException("Flight NOT found : "+flightNumber);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public Flight selectFlight(int flightNumber) {
        System.out.println("selecting flight...");
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from flights where flight_number="+flightNumber);
            if(resultSet.next()) {
                flightObj.setFlightNumber(resultSet.getInt(1));
                flightObj.setFlightName(resultSet.getString(2));
                flightObj.setFlightSource(resultSet.getString(3));
                flightObj.setFlightDestination(resultSet.getString(4));
            }
            else {
                throw new RuntimeException("Flight Not found "+flightNumber);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return flightObj;
    }

    @Override
    public List<Flight> selectFlights() {
        System.out.println("selecting all flights...");

        List<Flight> allFlights = new ArrayList<Flight>();

        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from flights");
            while(resultSet.next()) {
                Flight flightFound = new Flight();
                flightFound.setFlightNumber(resultSet.getInt(1));
                flightFound.setFlightName(resultSet.getString(2));
                flightFound.setFlightSource(resultSet.getString(3));
                flightFound.setFlightDestination(resultSet.getString(4));
                allFlights.add(flightFound);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return allFlights;
    }
}
