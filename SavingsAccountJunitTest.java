package com.company;

//who
//where when
//why what how

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//SavingsAccountJunitTest sajt = new SavingsAccountJunitTest();
//sajt.testOpenAccount();

//controller, service, repository/dao/orm testing
public class SavingsAccountJunitTest {

        @Test
        public void testOpenAccount() { // Dev-Ops
            System.out.println("line1");
            double openingBalance = 50000; //test data 1
            System.out.println("line3");
            SavingsAccount savingsAccount = new SavingsAccount(101,"Jack",openingBalance); //BL
        Assertions.assertNotNull(savingsAccount); //checking the non-empty ness of this reference
            System.out.println("line6");
            double currentBalanceAfterOpening = savingsAccount.getAccountBalance(); //BL test data 2
            System.out.println("line8");
        Assertions.assertEquals(openingBalance,currentBalanceAfterOpening,"Mismatch in the opening balance...");
            System.out.println("line10");
            System.out.println("line11 : testOpenAccount is done...");
        }

        @Test
        public void testWithdraw() {
            double openingBalance = 50000; //test data 1
            SavingsAccount savingsAccount = new SavingsAccount(101,"Jack",openingBalance); //BL
            //50000
            double currentBalanceBeforeWithdraw = savingsAccount.getAccountBalance();
            double amountToWithdraw=500;
            double balanceExpectedAfterWithdraw = currentBalanceBeforeWithdraw - amountToWithdraw;
            //500
            savingsAccount.withdraw(amountToWithdraw);//BL
            //49500
            double actualBalanceAfterWithdraw = savingsAccount.getAccountBalance();//BL  //test data 3
            //now the test condition2
            if(balanceExpectedAfterWithdraw == actualBalanceAfterWithdraw) {
                System.out.println("2. Test Passed - withdraw is correct...");
            }
            else {
                System.out.println("2. Test failed - withdraw is incorrect...");
                System.exit(2); //exit 1 means, first level of exit
            }
            System.out.println("test withdraw is done...");
        }

        @Test
        public void testDeposit() {
            double openingBalance = 50000; //test data 1
            SavingsAccount savingsAccount = new SavingsAccount(101,"Jack",openingBalance); //BL
            double currentBalanceBeforeDeposit = savingsAccount.getAccountBalance();
            double amountToDeposit=9000;
            double balanceExpectedAfterDeposit = currentBalanceBeforeDeposit + amountToDeposit;
            //500
            savingsAccount.deposit(amountToDeposit);//BL
            //49500
            double actualBalanceAfterDeposit = savingsAccount.getAccountBalance();//BL  //test data 3
            //now the test condition2
            if(actualBalanceAfterDeposit == balanceExpectedAfterDeposit) {
                System.out.println("3. Test Passed - deposit is correct...");
            }
            else {
                System.out.println("3. Test failed - deposit is incorrect...");
                System.exit(3); //exit 1 means, first level of exit
            }
            System.out.println("test deposit is done...");
        }

}
