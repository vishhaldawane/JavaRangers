
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.java.entity.Department;
import com.java.entity.Employee;


public class OneToManyCRUDTest4 {
	
	/*  
	 * EAGER loading
	 * 
	 * Hibernate: 
	 * 
	 * select 
	 * 
	 * department0_.deptno as deptno1_2_0_, 
	 * department0_.loc as loc2_2_0_, 
	 * department0_.dname as dname3_2_0_, 
	 * 
	 * empset1_.deptno as deptno4_3_1_, 
	 * empset1_.empNumber as empnumbe1_3_1_, 
	 * empset1_.empNumber as empnumbe1_3_2_, 
	 * empset1_.deptno as deptno4_3_2_, 
	 * empset1_.empName as empname2_3_2_, 
	 * empset1_.empSalary as empsalar3_3_2_ 
	 * 
	 * from DEPT8 department0_ left outer join EMPLOYEE8 
	 * empset1_ on department0_.deptno=empset1_.deptno 
	 * where department0_.deptno=?
	 * 

	 * 
	 */
	
	@Test
	public void fetchDeptAndEmployees() {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("MyJPA"); //persistence.xml is read here 
		
		System.out.println("Entity Manager Factory : "+entityManagerFactory);
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		//ctrl+shift+M
		
		System.out.println("Entity Manager : "+entityManager);
		
		//React UI -> Login : Nikita 
			Department dept = entityManager.find(Department.class, 10);
		/*	
		 * select 
			 * department0_.deptno as deptno1_2_0_, 
			 * department0_.loc as loc2_2_0_, 
			 * department0_.dname as dname3_2_0_ 
		 * from DEPT8 department0_ 
		 * where 
		 * department0_.deptno=?
		*/
		Assertions.assertNotNull(dept); //if dept found 
			
			System.out.println("Dept number   : "+dept.getDepartmentNumber());
			System.out.println("Dept name     : "+dept.getDepartmentName());
			System.out.println("Dept location : "+dept.getDepartmentLocation());
			System.out.println("==================");
			Set<Employee> empStaff = dept.getEmpSet(); //based on the department, get the employees
	/*		
	 * Hibernate: 
	 * select 
		 * empset0_.deptno as deptno4_3_0_, 
		 * empset0_.empNumber as empnumbe1_3_0_, 
		 * empset0_.empNumber as empnumbe1_3_1_, 
		 * empset0_.deptno as deptno4_3_1_, 
		 * empset0_.empName as empname2_3_1_, 
		 * empset0_.empSalary as empsalar3_3_1_ 
	 * from EMPLOYEE8 empset0_ 
	 * 	where empset0_.deptno=?
	*/	
		Assertions.assertTrue(empStaff.size() > 0 ); // if the staff is there
			for(Employee theEmp : empStaff) {
				System.out.println("Employee Number : "+theEmp.getEmpNumber());
				System.out.println("Employee Name   : "+theEmp.getEmpName());
				System.out.println("Employee Salary : "+theEmp.getEmpSalary());
				//Department d = theEmp.getDept();
				//d.getEmpSet();
				
				System.out.println("---------------");
				/*Department tempDept = theEmp.getDept(); //based on the emp, get the department
					System.out.println("->Dept number   : "+tempDept.getDepartmentNumber());
					System.out.println("->Dept name     : "+tempDept.getDepartmentName());
					System.out.println("->Dept location : "+tempDept.getDepartmentLocation());
					System.out.println("*********");
					Set<Employee> tempEmpStaff = tempDept.getEmpSet();
					*/
			} //angular + spring + JPA
		/*
		 * select 
		 * department0_.deptno as deptno1_2_0_, 
		 * department0_.loc as loc2_2_0_, 
		 * department0_.dname as dname3_2_0_, 
		 * 
		 * empset1_.deptno as deptno4_3_1_, 
		 * empset1_.empNumber as empnumbe1_3_1_, 
		 * empset1_.empNumber as empnumbe1_3_2_, 
		 * empset1_.deptno as deptno4_3_2_, 
		 * empset1_.empName as empname2_3_2_, 
		 * empset1_.empSalary as empsalar3_3_2_ 
		 * from DEPT7 department0_ 
		 * left outer join EMPLOYEE7 empset1_ 
		 * on department0_.deptno=empset1_.deptno 
		 * where department0_.deptno=?	
		*/
	}
	
	
	@Test
	public void insertDepartmentWithEmployees() {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("MyJPA"); //persistence.xml is read here 
		
		System.out.println("Entity Manager Factory : "+entityManagerFactory);
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		//ctrl+shift+M
		
		System.out.println("Entity Manager : "+entityManager);
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
			Department dept = new Department();
			
			dept.setDepartmentNumber(10);
			dept.setDepartmentName("IT");
			dept.setDepartmentLocation("NY");
			
			Employee empObj1 = new Employee(101,"Jack",5000.0f,dept);
			Employee empObj2 = new Employee(102,"Jane",6000.0f,dept);
			Employee empObj3 = new Employee(103,"Jill",7000.0f,dept);
			
			dept.getEmpSet().add(empObj1);
			dept.getEmpSet().add(empObj2);
			dept.getEmpSet().add(empObj3);
			
			entityManager.persist(dept);
			
			entityManager.persist(empObj1);
			entityManager.persist(empObj2);
			entityManager.persist(empObj3);
			
		transaction.commit();
	}
	
	@Test
	public void insertDepartmentWithEmployeesSet() {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("MyJPA"); //persistence.xml is read here 
		
		System.out.println("Entity Manager Factory : "+entityManagerFactory);
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		//ctrl+shift+M
		
		System.out.println("Entity Manager : "+entityManager);
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
			Department dept = new Department();
			
			dept.setDepartmentNumber(20);
			dept.setDepartmentName("SALES");
			dept.setDepartmentLocation("NJ");
			
			
			Set<Employee> employeeSet = new HashSet<Employee>();//blank set
			
			Employee empObj1 = new Employee(111,"Seeta",5000.0f,dept);
			Employee empObj2 = new Employee(112,"Geeta",6000.0f,dept);
			Employee empObj3 = new Employee(113,"Reeta",7000.0f,dept);
			
			employeeSet.add(empObj1); //no need of --> dept.getEmpSet().add(empObj1);
			employeeSet.add(empObj2); //no need of --> dept.getEmpSet().add(empObj2);
			employeeSet.add(empObj3); //no need of --> dept.getEmpSet().add(empObj3);
			
			dept.setEmpSet(employeeSet); //now the set is not blank, it has 3 emps in it
			
			entityManager.persist(dept);
			
			entityManager.persist(empObj1);
			entityManager.persist(empObj2);
			entityManager.persist(empObj3);
			
		transaction.commit();
	}
	
	@Test
	public void insertDepartmentWithEmployeesCascadeWay() {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("MyJPA"); //persistence.xml is read here 
		
		System.out.println("Entity Manager Factory : "+entityManagerFactory);
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		//ctrl+shift+M
		
		System.out.println("Entity Manager : "+entityManager);
		
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
			Department dept = new Department();
			
			dept.setDepartmentNumber(30);
			dept.setDepartmentName("Purchase");
			dept.setDepartmentLocation("NM");
			
			Set<Employee> employeeSet = new HashSet<Employee>();//blank set
			
				Employee empObj1 = new Employee(222,"Amar",3000.0f,dept);
				Employee empObj2 = new Employee(333,"Akbar",4000.0f,dept);
				Employee empObj3 = new Employee(444,"Anthony",5000.0f,dept);
			
			employeeSet.add(empObj1); // dept.getEmpSet().add(empObj1);
			employeeSet.add(empObj2);
			employeeSet.add(empObj3);
			
			dept.setEmpSet(employeeSet); //assign this new set to the dept
			
			entityManager.persist(dept);
			
			//DEPT->EMPs->BANK->PAYEEs->STATEMENT
		transaction.commit();
	}
	
	
	
	
}





