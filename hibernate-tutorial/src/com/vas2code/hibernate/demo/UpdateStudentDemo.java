package com.vas2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vas2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create a session
		Session session = factory.getCurrentSession();

		try {

			int studentId = 1;

			// Now get a new session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve a student based on the id: primary key
			System.out.println("Getting the student with the id: " + studentId);

			Student myStudent = session.get(Student.class, studentId);

			System.out.println("Updating student ");
			myStudent.setFirstName("Peter");

			// commit the transaction
			session.getTransaction().commit();

			// New Code

			session = factory.getCurrentSession();
			session.beginTransaction();

			// Update emails for all students
			System.out.println("Updating all the emails !");
			session.createQuery("update Student set email = 'pookie@gmail.com'").executeUpdate();

			// commit the transaction
			session.getTransaction().commit();
			;
			System.out.println("Done!!");

		} finally {
			factory.close();
		}
	}

}
