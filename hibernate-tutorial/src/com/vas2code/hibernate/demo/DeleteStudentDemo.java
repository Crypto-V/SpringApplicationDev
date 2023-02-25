package com.vas2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vas2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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

			// Delete the student
//			System.out.println("Delete the student: "+myStudent);
//			session.delete(myStudent);
			
			
			//Delete the student second way, hibernate query
			System.out.println("Delete using HQL query student 2");
			session.createQuery("delete from Student where id=2").executeUpdate();

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!!");

		} finally {
			factory.close();
		}
	}

}
