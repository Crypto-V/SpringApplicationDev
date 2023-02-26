package com.vas2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vas2code.hibernate.demo.entity.Employee;
import com.vas2code.hibernate.demo.entity.Student;

public class EmployeePrimaryKeyDemo {

	public static void main(String[] args) {
		
		
		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// Create a session
		Session session = factory.getCurrentSession();

		try {

			// Create the 3 student objects
			System.out.println("Creating 3 Employee Objects");
			Employee empl = new Employee("Vasile","Verejan","Fidesco");
			Employee empl1 = new Employee("George","Anderson","Amazon");
			Employee empl2 = new Employee("Bartosh","Gnida","Self");
			Employee empl3= new Employee("Muhamed","Ali","Champion");
			Employee empl4 = new Employee("Greogore","Josan","Loser");
			
			

			// Start or begining the transaction
			session.beginTransaction();

			// save transaction
			System.out.println("Saving the employees");
			session.save(empl);
			session.save(empl1);
			session.save(empl2);
			session.save(empl3);
			session.save(empl4);			

			// commit the transaction
			System.out.println("Commit the transaction");
			session.getTransaction().commit();
			System.out.println("Done!!");

		} finally {
			factory.close();
		}
	}

}
