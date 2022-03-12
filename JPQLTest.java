package com.company.jpql;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.company.JPAUtil;
import org.junit.jupiter.api.Test;


public class JPQLTest {

	@Test
	public void testDate() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date mydate = sdf.parse("2020-10-25");
		System.out.println(mydate);

	}
	@Test
	public void testJPQL() throws Exception {

	//	Scanner scanner = new Scanner(System.in);
	//	System.out.println("Enter the date (yyyy-MM-dd) : ");
	//	String stringDate = scanner.nextLine();

		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
				
		Bid b = entityManager.find(Bid.class, 1);
		System.out.println(b);
		System.out.println(b.getItem());
		//System.out.println(b.getMember());
		System.out.println("-------------");

		Item i = (Item) entityManager.find(Item.class, 1);
	    System.out.println(i);
	    System.out.println(i.getBids());
		System.out.println("---------------------------------");

	    String queryString = "select i from Item i where i.initialPrice >= 1000000";
	    List<Item> list = entityManager.createQuery(queryString).getResultList();
	    displayItem(list);

		System.out.println("=======================");



		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date mydate = sdf.parse("2020-10-25");
		System.out.println(mydate);

		String queryString2 = "select i from Item i where i.validTill = :valid";
	    List list2 = entityManager.createQuery(queryString2)
	    					.setParameter("valid", mydate)
	    					.getResultList();
	    displayItem(list2);
	    
	    //String queryString3 = "select distinct i from Item i join i.bids b where i.initialPrice > 10000"; 
		/*String queryString3 = "select distinct i from Item i inner join fetch i.bids b join b.member m where m.name='majrul'";
	    List<Item> list3 = entityManager.createQuery(queryString3).getResultList();
	    displayItem(list3);*/

	//	getAllItemsBasedOnPrice -> 'actual query is here'

		System.out.println("*********************");
	    Query query = entityManager.createNamedQuery("getAllItemsBasedOnPrice");
	//    query.setHint("javax.persistence.query.timeout", 30000);
	    query.setParameter("price", 500000.0);
	    List<Item> list4 = query.getResultList();
	    displayItem(list4);
	    	    
		entityManager.close();
	}



	private static void displayItem(List<Item> list) {
		for(Item item : list) {
			System.out.println(item);
			//System.out.println(item.getBids());			
			//System.out.println(item.getCategories());
		}
	}

	private static void displayCategory(List<Category> list) {
		for(Category category : list) {
			System.out.println(category.getName());
		}
	}

	private static void displayBid(List<Bid> list) {
		for(Bid bid : list) {
			System.out.println(bid);
			//System.out.println(bid.getItem().getName());
		}
	}

	private static void displayMember(List<Member> list) {
		for(Member member : list) {
			System.out.println(member.getName());
		}
	}
}
