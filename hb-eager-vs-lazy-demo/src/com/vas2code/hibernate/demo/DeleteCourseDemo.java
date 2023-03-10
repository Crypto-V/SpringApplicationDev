package com.vas2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.hql.spi.id.local.LocalTemporaryTableBulkIdStrategy;

import com.vas2code.hibernate.demo.entity.Course;
import com.vas2code.hibernate.demo.entity.Instructor;
import com.vas2code.hibernate.demo.entity.InstructorDetail;
import com.vas2code.hibernate.demo.entity.Student;

public class DeleteCourseDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// Create a session
		Session session = factory.getCurrentSession();
		try {

			// Start or begining the transaction
			session.beginTransaction();

			// get course form DBS
			int theID = 13;
			Course tempCourse = session.get(Course.class, theID);
			System.out.println("This is the session.get-->" + tempCourse);

			// Delete the course
			session.delete(tempCourse);

			// commit the transaction
			System.out.println("Commit the transaction");
			session.getTransaction().commit();
			System.out.println("Done!!");

		} finally {
			// add clean up code
			session.close();
			factory.close();
		}
	}

}
