package com.company;

import com.company.bank.SavingsAccount;

import java.io.*;

/*

        Object serialization Process

                - it is the process to WRITE the "PRIVATE data" of an object to the FILE/STORAGE

    Object de-serialization Process
                - it is the process to READ  the "PRIVATE data" of an object FROM the FILE/STORAGE
 */

public class ObjectDeSerializationTest {
    public static void main(String[] args)  {
        SavingsAccount savingsAccount = null;
        System.out.println("savings account details : "+savingsAccount);

        //how to READ this object details FROM the file....
        try {
            System.out.println("trying to read  a file...");
            FileInputStream fin = new FileInputStream("/Users/apple/bank/accounts.txt");
            System.out.println("File is ready...for reading......");

            System.out.println("Tyring to read an Object's input stream to read objects...");
            ObjectInputStream ois = new ObjectInputStream(fin); //associate the file here
            System.out.println("Object input stream is created...");
            
            System.out.println("Trying to read the private data (wow!!!) from the file....");
            savingsAccount = (SavingsAccount) ois.readObject(); //object is read from the file...
            System.out.println("Object is read from  the file...");

            System.out.println("savings account details : "+savingsAccount);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
