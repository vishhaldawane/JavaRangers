package com.company;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class MemberTest {
    public static void main(String[] args) {

        ApplicationContext container = new ClassPathXmlApplicationContext("members.xml");

        Member member = (Member) container.getBean("anyMember"); // new Member();
        member.setMemberId(3); //fake data
     //   member.setMemberName("jack"); //fake data

//        DriverManagerDataSource ds = new DriverManagerDataSource();
//        ds.setDriverClassName("org.hsqldb.jdbc.JDBCDriver");
//        ds.setUrl("jdbc:hsqldb:hsql://localhost/mydb");
//        ds.setUsername("SA");
//        ds.setPassword("");
//        member.setDataSource(ds);

        String theMemberName = member.getMemberName();
        System.out.println("Member name : "+theMemberName);
    }
}
