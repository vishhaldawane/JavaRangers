package com.company;

import java.sql.*;
import java.util.Scanner;

public class InsertSingleRecordTest {

    public static void main(String[] args) {
	// write your code here
        Connection connection=null;
        Statement statement; //SELECT QUERY
        ResultSet result = null;

        PreparedStatement preparedStatement=null; //INSERT QUERY


        try {
            System.out.println("Trying to load the hsqldb driver....");
            DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver()); //1
            System.out.println("Driver is registered...");

            System.out.println("Trying to connect to the hsql database...");//2
             connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/mydb","SA","");
            System.out.println("Connected to the database....");

            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Enter NEW department number : "); //your primary key value
            int newDeptNumber = scanner1.nextInt(); //accept value from the keyboard

            statement = connection.createStatement(); //SELECT QUERY
            result = statement.executeQuery("SELECT * FROM MYDEPT WHERE DEPTNO="+newDeptNumber); //10

            if(result.next()) { //oh...means if the record is there....
                DepartmentAlreadyExistException departmentAlreadyExistException = new DepartmentAlreadyExistException("This department number is already present in the table..."+newDeptNumber);
                throw departmentAlreadyExistException;
            }
            else { //if the newDeptNot present in the DB, means our record would be the NEW ONE
                System.out.println("trying to create a statement object...");
                preparedStatement = connection.prepareStatement("insert into mydept values(?,?,?) ");
                System.out.println("PreparedStatement is created....");
            }

            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Enter NEW department name : ");
            String newDeptName  = scanner2.nextLine();//accept a new string value

            Scanner scanner3= new Scanner(System.in);
            System.out.println("Enter NEW department location : ");
            String newDeptLocation = scanner3.nextLine();

    //Frame is better

            preparedStatement.setInt(1,newDeptNumber);
            preparedStatement.setString(2,newDeptName);
            preparedStatement.setString(3,newDeptLocation);

            System.out.println("tyring to run the query....");
            int numebrOfRowsAdded = preparedStatement.executeUpdate();
            System.out.println("Number of rows added : "+numebrOfRowsAdded);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            System.out.println("trying to close the resources...");
            try {
               //close from latest to the oldest resource
                if(preparedStatement!=null)
                    preparedStatement.close();

                if(result!=null)
                    result.close();

                connection.close();
            }
            catch (SQLException exception) {
                System.out.println("Some problem while closing the resources..."+exception);
            }
            System.out.println("all db resources are closed.....");
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