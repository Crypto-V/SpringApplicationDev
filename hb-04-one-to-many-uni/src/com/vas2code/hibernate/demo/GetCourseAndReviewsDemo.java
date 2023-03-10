package com.vas2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vas2code.hibernate.demo.entity.Course;
import com.vas2code.hibernate.demo.entity.Instructor;
import com.vas2code.hibernate.demo.entity.InstructorDetail;
import com.vas2code.hibernate.demo.entity.Review;
import com.vas2code.hibernate.demo.entity.Student;

public class GetCourseAndReviewsDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();

		// Create a session
		Session session = factory.getCurrentSession();

		try {

			// Start the transaction
			session.beginTransaction();
			
			//get the course
			int id = 10;
			Course tempCourse = session.get(Course.class, id);
			
			//print the course
			System.out.println("vas2code: the course--> "+tempCourse);
			
			//print the course reviews
			System.out.println("\n Reviews got that course start here: \n");
			System.out.println(tempCourse.getReviews());

			

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
