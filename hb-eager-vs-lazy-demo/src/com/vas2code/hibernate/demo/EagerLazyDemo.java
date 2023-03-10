package com.vas2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.hql.spi.id.local.LocalTemporaryTableBulkIdStrategy;

import com.vas2code.hibernate.demo.entity.Course;
import com.vas2code.hibernate.demo.entity.Instructor;
import com.vas2code.hibernate.demo.entity.InstructorDetail;
import com.vas2code.hibernate.demo.entity.Student;

public class EagerLazyDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

		// Create a session
		Session session = factory.getCurrentSession();

		try {

			// Start or begining the transaction
			session.beginTransaction();

			int theId = 1;

			// get the instructor from db
			Instructor tempInstructor = session.get(Instructor.class, theId);

			System.out.println("vas2code: Instructor: "+tempInstructor);
			System.out.println("vas2code: List of courses: \n");
			System.out.println("vas2code: Courses: "+tempInstructor.getCourses());
			
			
			

			// commit the transaction
			System.out.println("vas2code: Commit the transaction");
			session.getTransaction().commit();
			
			
			session.close();
			System.out.println("vas2code: Courses after session close: "+tempInstructor.getCourses());
			System.out.println("vas2code: Done!!");

		} finally {
			// add clean up code
			session.close();
			factory.close();
		}
	}

}
