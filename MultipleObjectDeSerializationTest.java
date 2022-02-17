package com.company;

import com.company.bank.SavingsAccount;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/*

        Object serialization Process

                - it is the process to WRITE the "PRIVATE data" of an object to the FILE/STORAGE

    Object de-serialization Process
                - it is the process to READ  the "PRIVATE data" of an object FROM the FILE/STORAGE
 */
//
class Bank
{
    SavingsAccount savingsAccount; //here no need of null, cause it is data member HERE

    void processTheAccounts() {

    }
}
public class MultipleObjectDeSerializationTest {
    public static void main(String[] args)  {
        int x=0;
        System.out.println("x "+x);

        //below is a local variable
        SavingsAccount savingsAccount1 = null; //local variable must be initialized
        SavingsAccount savingsAccount2 = null;
        SavingsAccount savingsAccount3 = null;

        System.out.println("savings account details1 : "+savingsAccount1);
        System.out.println("savings account details2 : "+savingsAccount2);
        System.out.println("savings account details3 : "+savingsAccount3);


        //how to READ this object details FROM the file....
        try {
            System.out.println("trying to read  a file...");
            FileInputStream fin = new FileInputStream("/Users/apple/bank/acc_many.txt");
            System.out.println("File is ready...for reading......");

            System.out.println("Tyring to read an Object's input stream to read objects...");
            ObjectInputStream ois = new ObjectInputStream(fin); //associate the file here
            System.out.println("Object input stream is created...");
            
            System.out.println("Trying to read the private data (wow!!!) from the file....");
            savingsAccount1 = (SavingsAccount) ois.readObject(); //object is read from the file...
            savingsAccount2 = (SavingsAccount) ois.readObject(); //object is read from the file...
            savingsAccount3 = (SavingsAccount) ois.readObject(); //object is read from the file...

            System.out.println("Objects are read from  the file...");

           System.out.println("savings account details1 : "+savingsAccount1);
           System.out.println("savings account details2 : "+savingsAccount2);
           System.out.println("savings account details3 : "+savingsAccount3);

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
