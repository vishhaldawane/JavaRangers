package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        try {
            System.out.println("Trying to load the hsqldb driver....");
            DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver()); //1
            System.out.println("Driver is registered...");

            System.out.println("Trying to connect to the hsql database...");//2
            Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/mydb","SA","");
            System.out.println("Connected to the database....");

            System.out.println("trying to create a statement object...");
            Statement statement = connection.createStatement();
            System.out.println("Statement is created....");

            System.out.println("tyring to run the query..and acquiring the result...");
            ResultSet result = statement.executeQuery("SELECT * FROM MYDEPT"); //QUERY CAN BE IN ANY CASE
            System.out.println("Got the result...now processing it...");

            while(result.next()) { //iterate each row of the table
                int x = result.getInt(1); // this is the first integer column of your table
                String y = result.getString(2);  //2nd column of string type
                String z = result.getString(3); //3rd column of string type
                System.out.println("Department number   : "+x);
                System.out.println("Department Name     :"+y);
                System.out.println("Department Location : "+z);
                System.out.println("---------------------------");
            }


            System.out.println("trying to close the resources...");

            result.close(); //close from latest to the oldest resource
            statement.close();
            connection.close();

            System.out.println("all db resources are closed.....");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
/*
                    JDBC
                    |
               Java             Database connectivity
                |                   |
              your java code <--> database
                                    |
                                   Oracle
                                   MS-SQL
                                   MySQL
                                   Sybase
                                   HSQL<==


          1. download hsqldb.jar file from the net
                    http://hsqldb.org/
          2. https://sourceforge.net/projects/hsqldb/files/
                    click to download this file -> Download latest version 2.6.1
          3. extract this zip file at a relevant location,eg. c:\windows
                    or d:\anyfolder

          4. cd d:\anyfolder\hsqldb-2.6.1\lib

          5. java -cp hsqldb.jar org.hsqldb.server.Server --database.0 file:hibernatedb --dbname.0 mydb
            IF THE JAVA COMMAND IS NOT FOUND, THEN
            SET THE JETBRAIN'S JDB\BIN FOLDER IN THE PATH
                set path=c:\programfiles\intellij\jetbrain\bin;%path%
                    if u want the path to be fixed,
                    then set it in the env variables of the os
                    ->adv system settings

               JDBC STEPS
java.sql package
               *. U SHOULD KNOW YOUR DATABASE AND ITS DRIVER NAME
                                        HSqlBD      org.hsqldb.jdbc.JDBCDriver
               1. LOAD THE DRIVER - TO  CONNECT TO THE DB
                    DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());

               2. ACQUIRE TEH CONNECTION.. TO THE DB
                    Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/mydb","SA","");

               3. make a desired statement to run
                            "select"/insert/update/delete|procedure/function
                  Statement st = conn.createStatement();

               4. Type the statement query and run it to acquire the result

                   ResultSet rs  =    st.executeQuery("SELECT * FROM MYDEPT");

                5. Process this result
                            rs.next();




 */