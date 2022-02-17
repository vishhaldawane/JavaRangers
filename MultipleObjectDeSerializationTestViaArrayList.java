package com.company;

import com.company.bank.SavingsAccount;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;

/*

        Object serialization Process

                - it is the process to WRITE the "PRIVATE data" of an object to the FILE/STORAGE

    Object de-serialization Process
                - it is the process to READ  the "PRIVATE data" of an object FROM the FILE/STORAGE
 */
//


public class MultipleObjectDeSerializationTestViaArrayList {
    public static void main(String[] args)  {

        //blank array list below...
        ArrayList<SavingsAccount> allAccountsList = new ArrayList<SavingsAccount>();

        //how to READ this object details FROM the file....
        try {
            System.out.println("trying to read  a file...");
            FileInputStream fin = new FileInputStream("/Users/apple/bank/acc_many_list.txt");
            System.out.println("File is ready...for reading......");

            System.out.println("Tyring to read an Object's input stream to read objects...");
            ObjectInputStream ois = new ObjectInputStream(fin); //associate the file here
            System.out.println("Object input stream is created...");
            
            System.out.println("Trying to read the private data (wow!!!) ArrayList from the file....");
            allAccountsList = (ArrayList<SavingsAccount>) ois.readObject(); //object is read from the file...

            System.out.println("Objects as ArrayList are read from  the file...");

            //retrieve the iterator of the arrayList...
            Iterator<SavingsAccount> accountIterator = allAccountsList.iterator();

            //check if the iterator has a next object in it...(ie the first object)
            while(accountIterator.hasNext()) {
                SavingsAccount savingsAccount = accountIterator.next();//retrieve that first object
                System.out.println("savings account : "+savingsAccount);
            }

           ois.close();
           fin.close();
            System.out.println("resources are closed...");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
