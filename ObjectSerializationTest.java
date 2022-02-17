package com.company;

import com.company.bank.SavingsAccount;

import java.io.*;

/*

        Object serialization Process

                - it is the process to WRITE the "PRIVATE data" of an object to the FILE/STORAGE

    Object de-serialization Process
                - it is the process to READ  the "PRIVATE data" of an object FROM the FILE/STORAGE

          (in memory)       acno    acholder    acbalance
        savingsAccount ---> 101     jack           5000 <--private
                |                                       savingsAccount =null
                |        (secondary memory)             |
      1        fout --->--> account.txt --->-------->   fin    2
               |            |                           |
               oos          |serialized   de-serialize  ois
               |            |                           |
              oos.writeObject(savingsAccount)      ois.readObject();




 */

public class ObjectSerializationTest {
    public static void main(String[] args)  {
        SavingsAccount savingsAccount = new SavingsAccount(111,"Ramji",9000,3234);
        System.out.println("savings account details : "+savingsAccount);

        //how to store these object details on the file....
        try {
            System.out.println("trying to create a file...");
            FileOutputStream fout = new FileOutputStream("/Users/apple/bank/accounts.txt");
            System.out.println("File is ready...for writing....");

            System.out.println("Tyring to make an Object's output stream to write objects...");
            ObjectOutputStream oos = new ObjectOutputStream(fout); //associate the file here
            System.out.println("Object output stream is created...");

            System.out.println("Trying to write the private data (ohhh!!!) to the file....");
            oos.writeObject(savingsAccount); //object is written to the file...
            System.out.println("Object is written to the file...");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
