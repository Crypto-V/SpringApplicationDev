package com.vas2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vas2code.hibernate.demo.entity.Course;
import com.vas2code.hibernate.demo.entity.Instructor;
import com.vas2code.hibernate.demo.entity.InstructorDetail;
import com.vas2code.hibernate.demo.entity.Student;

public class CreateCoursesDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// Create a session
		Session session = factory.getCurrentSession();

		try {

			// Start or begining the transaction
			session.beginTransaction();

			int theId = 1;

			// get the instructor from db
			Instructor tempInstructor = session.get(Instructor.class, theId);

			// create some courses
			System.out.println("<--Creating the courses:-->");
			Course cs1 = new Course("Math");
			Course cs2 = new Course("CS");
			Course cs3 = new Course("Physics");

			// add courses to instructor
			System.out.println("<--Add Courses to the instructor:-->" + tempInstructor);
			tempInstructor.add(cs1);
			tempInstructor.add(cs2);
			tempInstructor.add(cs3);

			// save the courses
			System.out.println("<--Saving the instructor:-->" + tempInstructor);
			session.save(cs1);
			session.save(cs2);
			session.save(cs3);

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
