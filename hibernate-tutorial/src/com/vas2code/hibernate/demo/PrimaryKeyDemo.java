package com.vas2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vas2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		
		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create a session
		Session session = factory.getCurrentSession();

		try {

			// Create the 3 student objects
			System.out.println("Creating 3 student object...");
			Student tempStudent = new Student("Vasile", "Verejan", "vv@gmail.com");
			Student tempStudent1 = new Student("George", "Adams", "ga@gmail.com");
			Student tempStudent2 = new Student("Peter", "Mclister", "pm@gmail.com");
			Student tempStudent3 = new Student("Joshua", "Hren", "jh@gmail.com");

			// Start or begining the transaction
			session.beginTransaction();

			// save transaction
			System.out.println("Saving the students");
			session.save(tempStudent);
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			// commit the transaction
			System.out.println("Commit the transaction");
			session.getTransaction().commit();
			System.out.println("Done!!");

		} finally {
			factory.close();
		}
	}

}
