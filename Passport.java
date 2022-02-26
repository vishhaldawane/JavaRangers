package com.company.onetoone;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="passport12")
public class Passport {

    @Id
    @Column(name="passportno") //1
    int passportNumber;

    @Column(name="issuedby") //2
    String passportIssuedBy;

    @Column(name="issuedon") //3
    LocalDate passportIssuedOn;

    @Column(name="expiryon") //4
    LocalDate passportExpiryOn;

    //4th column below, is a REAL column
    @OneToOne
    @JoinColumn(name="eno",unique = true) //5
    Employee employee;

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getPassportIssuedBy() {
        return passportIssuedBy;
    }

    public void setPassportIssuedBy(String passportIssuedBy) {
        this.passportIssuedBy = passportIssuedBy;
    }

    public LocalDate getPassportIssuedOn() {
        return passportIssuedOn;
    }

    public void setPassportIssuedOn(LocalDate passportIssuedOn) {
        this.passportIssuedOn = passportIssuedOn;
    }

    public LocalDate getPassportExpiryOn() {
        return passportExpiryOn;
    }

    public void setPassportExpiryOn(LocalDate passportExpiryOn) {
        this.passportExpiryOn = passportExpiryOn;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

