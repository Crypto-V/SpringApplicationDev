package com.vas2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vas2code.hibernate.demo.entity.Employee;
import com.vas2code.hibernate.demo.entity.Student;

public class QueryEmployeeDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// Create a session
		Session session = factory.getCurrentSession();

		try {

			// Start the transaction
			session.beginTransaction();

			// query employees
			List<Employee> theEmployees = session.createQuery("from Employee").getResultList();

			// Display employees
			System.out.println("\n\nDisplay all employees");
			displayEmployees(theEmployees);

			// query employees : company = 'Saslik'
			theEmployees = session.createQuery("from Employee s where s.company = 'Saslik'").getResultList();

			// Display employees
			System.out.println("\n\n\nDisplay employees with the company name Saslik");
			displayEmployees(theEmployees);

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!!");

		} finally {
			factory.close();
		}
	}

	private static void displayEmployees(List<Employee> theEmployees) {
		for (Employee tempEmployee : theEmployees) {
			System.out.println(tempEmployee.toString());

		}
	}

}
