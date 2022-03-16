package com.company;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*


CREATE TABLE ACCOUNTS
(
ACNO INT PRIMARY KEY,
ACNAME VARCHAR(20),
ACBAL INT
)


 */
public class SavingsAccount
{
    int accountNumber;
    String accountHolderName;
    double accountBalance;

    DataSource dataSource ;


    public SavingsAccount() {
        System.out.println("SavingsAccount()...no argument ctor...");
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;

    }


    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        System.out.println("setAccountNumber() invoked...");
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        System.out.println("setAccountHolderName() invoked...");
        this.accountHolderName = accountHolderName;
    }

    public double getAccountBalance() {

        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select acbal from ACCOUNTS WHERE ACNO="+getAccountNumber());

            if(rs.next()) {
                accountBalance = rs.getInt(1);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        System.out.println("setAccountBalance() invoked...");
        this.accountBalance = accountBalance;
    }

    void withdraw() {

        System.out.println("Withdrawing....");
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "accountNumber=" + accountNumber +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", accountBalance=" + accountBalance +
                '}';
    }
}

