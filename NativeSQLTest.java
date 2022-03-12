package com.company.jpql;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.company.JPAUtil;
import org.junit.jupiter.api.Test;



public class NativeSQLTest {


	@Test
	public void printArray() {
		int nums[]={10,20,30,40,50};
		System.out.println(Arrays.toString(nums));
	}
	@Test
	public void testNativeSQL() {
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.createQuery("from Item");//JPQL
		Query query = entityManager.createNativeQuery(
				"SELECT * FROM items WHERE initialPrice > 1000000");
		List<Object[]> items = query.getResultList();
		for (Object[] item : items)
			System.out.println(Arrays.toString(item));// 1970s C, 1980s C++, 1994-2022 Java - One Language - MultiPlatform
		System.out.println("----------------------------------------");
		Query query1 = entityManager.createNativeQuery(
				"SELECT * FROM items WHERE initialPrice > 1000000", Item.class);

		List<Item> items1 = query1.getResultList();
		for (Item item : items1) {
			System.out.println(item.getName());
			System.out.println(item.getInitialPrice());
			System.out.println("---------");
		}
		
		entityManager.close();
	}
}
