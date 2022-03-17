package com.company;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Member {

    private int memberId;
    private String memberName;

    private DataSource dataSource; //initially it is blank | null



    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {

        //memberName=memberId+" ALWAYS THIS NAME";

        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select name from members where member_id=" + memberId);
            if (resultSet.next()) {
                memberName = resultSet.getString(1);
            } else {
                memberName = "NOT FOUND"; //funny
            }
        }
        catch(Exception exception) {
            System.out.println("Exception  : "+exception);
        }

        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) { // it is set here
        this.dataSource = dataSource; //no longer a null now
    }
}
