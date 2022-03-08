package com.java.one2one;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/*
 * 		One Person   <--> One Passport
 * 		One Passport <--> One Person
 
  PK					   FK(unique)
  personid	personName    PASSPORTID
  1			Jack		  123
  2			Jane		  334
  3			Jill		  
  
  
  1  - tables - ER diagram  7/8
  2  - pojos - entities
  3  - repos
  4  - service <-- 
  5  - spring rest api calls
  6  - react
  
 */
@Entity
@Table(name="person1")
public class Person {

	@Id
	@GeneratedValue
	private int personId; //1
	
	private String personName; //2
	
	@OneToOne
	private Passport passport;//hasA
	
	
	
	public Passport getPassport() {
		return passport;
	}


	public void setPassport(Passport passport) {
		this.passport = passport;
	}


	public Person() {
		// TODO Auto-generated constructor stub
		System.out.println("Person()...");
	}


	public int getPersonId() {
		return personId;
	}


	public void setPersonId(int personId) {
		this.personId = personId;
	}


	public String getPersonName() {
		return personName;
	}


	public void setPersonName(String personName) {
		this.personName = personName;
	}
	
	

}
