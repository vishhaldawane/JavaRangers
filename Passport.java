package com.java.one2one;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/*
  PK										  FK(unique)
  passportId  issuedBy  issuedDate expiryDate PERSONID
   123		  Govt.Ind  2021-10-12 2032-10-12 1
   334		  Govt.Ind  2021-12-07 2032-12-07 2	
   556		  Govt.Ind  2021-12-07 2032-12-07 2
 */
@Entity
@Table(name="passport1")
public class Passport {

	@Id
	@GeneratedValue
	private int passportId; //1
	
	private String issuedBy; //2
	private LocalDate issueDate; //3
	private LocalDate expiryDate; //4
	
	@OneToOne
	private Person person;
	
	
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Passport() {
		// TODO Auto-generated constructor stub
		System.out.println("Passport()..");
	}

	public int getPassportId() {
		return passportId;
	}

	public void setPassportId(int passportId) {
		this.passportId = passportId;
	}

	public String getIssuedBy() {
		return issuedBy;
	}

	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	
}
