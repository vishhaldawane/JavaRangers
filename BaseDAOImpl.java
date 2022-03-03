package com.company;

import java.io.Serializable;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/*BaseDAOImpl base = new BaseDAOImpl();
Flight flight = new Flight(); //101 mapped to flight_tbl
Savings sav = new Savings(); //4586 mapped to savings_tbl
base.persistAnyObject(flight);
base.persistAnyObject(sav);

Flight f = em.findAnyObject(Flight.class,101);
Savings s = em.findAnyObject(Savings.class,4586);

*/

public class BaseDAOImpl { //USER DEFINED CLASS
	EntityManagerFactory entityManagerFactory ; //emf | line number 21 will initialize it
	
	public EntityManager getEntityManager() {
		EntityManager entityManager = entityManagerFactory.createEntityManager(); // emf.createEntityManager();
		return entityManager; //em
	}
	public BaseDAOImpl() {
		//this.emf =  Persistence.createEntityManagerFactory("MyJPA");
		this.entityManagerFactory = Persistence.createEntityManagerFactory("MyJPA"); //this will read the persistence.xml file
	}
	public void persistAnyObject(Object obj) { //persist is a dummy/USER DEFINED METHOD
		EntityManager entityManager = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();  	
					entityManager.persist(obj);	//the real persist method is here
					entityTransaction.commit();
		} finally { entityManager.close(); }

	}
	public <AnyClass> AnyClass findAnyObject(Class<AnyClass> theClass, Serializable pk ) {
		EntityManager entityManager = null;
		AnyClass foundAnyObjRef = null;
		try {			
			entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			foundAnyObjRef = entityManager.find(theClass, pk);
			entityTransaction.commit();
		} finally { entityManager.close(); }
			return foundAnyObjRef;
	}
	public <E> List  findAll(String pojoName) {
		EntityManager entityManager = null;
		
		try {			
			entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			//entityTransaction.begin();  	
			Query query = entityManager.createQuery(" from "+ pojoName);
			return query.getResultList();
			//entityTransaction.commit();
		} finally { entityManager.close(); }
	}
	public void mergeAnyObject(Object obj) {
		EntityManager entityManager = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();  	
					entityManager.merge(obj);	
					entityTransaction.commit();
		} finally { entityManager.close(); }
		
	}
	public void removeAnyObject(Object obj) {
		EntityManager entityManager = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();  	
					entityManager.remove(obj);	
					entityTransaction.commit();
		} finally { entityManager.close(); }
	}
}
