package com.company;

//who
//where when
//why what how

public class SavingsAccountTest {
    public static void main(String[] args) {

        double openingBalance = 50000; //test data 1

        SavingsAccount savingsAccount = new SavingsAccount(101,"Jack",openingBalance); //BL

        double currentBalanceAfterOpening = savingsAccount.getAccountBalance(); //BL test data 2
        //now the test condition1

        if(openingBalance == currentBalanceAfterOpening) {
            System.out.println("1. Test Passed - opening balance is correct...");
        }
        else {
            System.out.println("1. Test Failed - opening balance is NOT correct...");
            System.exit(1); //exit 1 means, first level of exit
        }

        System.out.println("--------------------");

        //50000
        double currentBalanceBeforeWithdraw = savingsAccount.getAccountBalance();
        double amountToWithdraw=500;
        double balanceExpectedAfterWithdraw = currentBalanceBeforeWithdraw - amountToWithdraw;

        //500
        savingsAccount.withdraw(amountToWithdraw);//BL

        //49500
        double actualBalanceAfterWithdraw = savingsAccount.getAccountBalance();//BL  //test data 3

//Assertions

        //now the test condition2
        if(balanceExpectedAfterWithdraw == actualBalanceAfterWithdraw) {
            System.out.println("2. Test Passed - withdraw is correct...");
        }
        else {
            System.out.println("2. Test failed - withdraw is incorrect...");
            System.exit(2); //exit 1 means, first level of exit
        }
        System.out.println("--------------------");
        //50000
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


        System.out.println("All test cases PASSED!!!!");
        //System.exit(0); //SUCCESS - maze is over...
    }
}
