package com.vas2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vas2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create a session
		Session session = factory.getCurrentSession();

		try {

			// Create the student object
			System.out.println("Creating a new student object...");
			Student tempStudent = new Student("Daffy", "Dog", "big-dd@gmail.com");

			// Start or begining the transaction
			session.beginTransaction();

			// save transaction
			System.out.println("Saving the student");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			// close the session
			session.close();

			// My new code

			// find out the student id:primary key
			System.out.println("Saved studetn . Generated ID: " + tempStudent.getId());

			// Now get a new session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve a student based on the id: primary key
			System.out.println("Getting the student with the id: " + tempStudent.getId());
			Student myStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("Get complete: " + myStudent);

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!!");

		} finally {
			factory.close();
		}
	}

}
