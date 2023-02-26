package com.vas2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vas2code.hibernate.demo.entity.Employee;

public class DeleteEmployeeDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// Create a session
		Session session = factory.getCurrentSession();

		try {

			int emplId = 10;

			// Now get a new session and start a transaction
			session.beginTransaction();

			// retrieve a employee based on the id: primary key
			System.out.println("Getting the employee with the id: " + emplId);

			Employee myEmployee = session.get(Employee.class, emplId);

			// Delete the employee after retrieving
//			System.out.println("Delete the empl: "+myEmployee);
//			session.delete(myEmployee);
			
			
			//Delete the empl second way, hibernat e query
			System.out.println("Delete using HQL query empl 9");
			session.createQuery("delete from Employee where id=9").executeUpdate();

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!!");

		} finally {
			factory.close();
		}
	}

}
