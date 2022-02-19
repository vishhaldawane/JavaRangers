package com.company;

import java.sql.*;
import java.util.Scanner;

public class SelectSingleRecordTest {

    public static void main(String[] args) {
	// write your code here
        Connection connection=null;
        Statement statement=null;
        ResultSet result=null;

        try {
            System.out.println("Trying to load the hsqldb driver....");
            DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver()); //1
            System.out.println("Driver is registered...");

            System.out.println("Trying to connect to the hsql database...");//2
             connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/mydb","SA","");
            System.out.println("Connected to the database....");

            System.out.println("trying to create a statement object...");
            statement = connection.createStatement();
            System.out.println("Statement is created....");

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter department number to search : ");
            int deptNumberToFind = scanner.nextInt(); //accept value from the keyboard

            System.out.println("tyring to run the query..and acquiring the result...");
            result = statement.executeQuery("SELECT * FROM MYDEPT where deptno="+deptNumberToFind); //QUERY CAN BE IN ANY CASE

            if(result.next()) { //if that single record found then show it
                System.out.println("Got the result...now processing it...");
                int x = result.getInt(1); // this is the first integer column of your table
                String y = result.getString(2);  //2nd column of string type
                String z = result.getString(3); //3rd column of string type
                System.out.println("Department number   : "+x);
                System.out.println("Department Name     :"+y);
                System.out.println("Department Location : "+z);
                System.out.println("---------------------------");
            }
            else {
                //1. simple user-defined plain texted error msg
                //System.out.println("Department number NOT found : "+deptNumberToFind);

                //2 . system defined exception throwing...
                //RuntimeException exception = new RuntimeException("Department number NOT found : "+deptNumberToFind);

                //3 user defined exception throwing
                DepartmentNotFoundException departmentNotFoundException = new DepartmentNotFoundException("Department number NOT found : "+deptNumberToFind);
                throw departmentNotFoundException; //this error would be thrown and your application would be terminated..abruptly
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            System.out.println("trying to close the resources...");
            try {
                result.close(); //close from latest to the oldest resource
                statement.close();
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