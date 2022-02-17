package com.company;

import com.company.bank.SavingsAccount;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

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

public class MultipleObjectSerializationTestViaArrayList {
    public static void main(String[] args)  {
        SavingsAccount savingsAccount1 = new SavingsAccount(111,"Ramji",9000,3234);
        SavingsAccount savingsAccount2 = new SavingsAccount(222,"Arun",95000,1234);
        SavingsAccount savingsAccount3 = new SavingsAccount(333,"Piyush",8500,6234);

        System.out.println("savings account1 details : "+savingsAccount1);
        System.out.println("savings account2 details : "+savingsAccount2);
        System.out.println("savings account3 details : "+savingsAccount3);

        ArrayList<SavingsAccount> allAccountsList = new ArrayList<SavingsAccount>();
        allAccountsList.add(savingsAccount1); //fill up the array list
        allAccountsList.add(savingsAccount2);//fill up the array list
        allAccountsList.add(savingsAccount3);//fill up the array list



        //how to store these object details on the file....
        try {
            System.out.println("trying to create a file...");
            FileOutputStream fout = new FileOutputStream("/Users/apple/bank/acc_many_list.txt");
            System.out.println("File is ready...for writing....");

            System.out.println("Tyring to make an Object's output stream to write objects...");
            ObjectOutputStream oos = new ObjectOutputStream(fout); //associate the file here
            System.out.println("Object output stream is created...");

            System.out.println("Trying to write the private data (ohhh!!!) of array list to the file....");
            oos.writeObject(allAccountsList); //object is written to the file...
            System.out.println("array list is serialized .....");


            System.out.println("Objects present inside arraylist are written to the file...");
            oos.close();
            fout.close();
            System.out.println("close the resources....");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
