package com.company;


/*


    Software Development Life Cycle

    1. System Requirement analysis
    2. Design of the system - developer - coding...
            Flight engineers -> construct the flight

    3. Testing of the system -> testers ...
            ground level testing
            on the runway testing
            in the air testing
            landing testing
            engine testing

            Junit - java based testing framework



    4. deployment -

            Test pilots and their unit  -> to test the flight

60*24 hours

125th hour - out of no reason it is down!!!!!??????


60 days consistently  the engine is kept on
robust ness of the engine

AirIndia - flight AI-101
Mumbai to London - 9 hours flight journey
London to Mumbai - 9 hours return journey
9
9
9
9
9
9
9
9
9
9
9
9
9
9
9
9



 */
public class JunitTest {

    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount(101,"Arun",50000);
        System.out.println("sav acc obj : "+savingsAccount);

        savingsAccount.withdraw(500);
        System.out.println("sav acc obj : "+savingsAccount);

        savingsAccount.deposit(9000);
        System.out.println("sav acc obj : "+savingsAccount);


    }

}

//this component is created by the DEVELOPER!!!!
//but who will test this component


class SavingsAccount // 50 test cases...
{
    private int accountNumber;
    private String accountHolderName;
    private double accountBalance;

    public SavingsAccount(int accountNumber, String accountHolderName, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountBalance = accountBalance;
        this.accountBalance=accountBalance-0.0011;

    }

    void withdraw(double amountToWithdraw) {
        System.out.println("Withdrawing..."+amountToWithdraw);
        accountBalance = accountBalance - amountToWithdraw;
      //  accountBalance=accountBalance-0.0001; //subtle level deduction here...
    }
    void deposit(double amountToDeposit) {
        System.out.println("Depositing..."+amountToDeposit);
        accountBalance = accountBalance + amountToDeposit;
     //   accountBalance=accountBalance-0.002;
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "accountNumber=" + accountNumber +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", accountBalance=" + accountBalance +
                '}';
    }

    public int getAccountNumber() { //select QUERY - ORMs find
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) { //INSERT / UPDATE - ORMs persist /  merge
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
}
