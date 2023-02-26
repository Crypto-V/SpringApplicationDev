package com.vas2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vas2code.hibernate.demo.entity.Employee;
import com.vas2code.hibernate.demo.entity.Student;

public class EmployeeRetrieveDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// Create a session
		Session session = factory.getCurrentSession();

		try {
			// Create the employee object
			System.out.println("Creating a new student object...");
			Employee empl = new Employee("Daffy", "Dog", "Saslik");

			// Start or begining the transaction
			session.beginTransaction();

			// save transaction
			System.out.println("Saving the employee");
			System.out.println(empl);
			session.save(empl);

			// commit the transaction
			session.getTransaction().commit();

			// close the session
			session.close();

			// My new code

			// find out the empl id:primary key
			
			System.out.println("Saved studetn . Generated ID: " + empl.getId());

			// Now get a new session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve a empl based on the id: primary key
			System.out.println("Getting the empl with the id: " + empl.getId());
			Employee employee = session.get(Employee.class, empl.getId());
			System.out.println("Get complete: " + empl.getId());

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!!");

		} finally {
			factory.close();
		}
	}

}
