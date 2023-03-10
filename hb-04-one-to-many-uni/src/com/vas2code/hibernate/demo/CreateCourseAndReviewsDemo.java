package com.vas2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vas2code.hibernate.demo.entity.Course;
import com.vas2code.hibernate.demo.entity.Instructor;
import com.vas2code.hibernate.demo.entity.InstructorDetail;
import com.vas2code.hibernate.demo.entity.Review;
import com.vas2code.hibernate.demo.entity.Student;

public class CreateCourseAndReviewsDemo {

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
			
			//create course
			Course tempCourse = new Course("The hibernate journey");
			System.out.println("vas2code: created course "+tempCourse);
			
			// create and add some reviews
			Review tempReview = new Review("That was an fantastic oportunity!");
			Review tempReview1 = new Review("Excellent!");
			Review tempReview2 = new Review("Nice job!");
			Review tempReview3 = new Review("You deserve a medal!");
			
			tempCourse.addReview(tempReview);
			tempCourse.addReview(tempReview1);
			tempCourse.addReview(tempReview2);
			tempCourse.addReview(tempReview3);
			
			//save the course .. and leverage the cascade all
			System.out.println("Saving the course that will automatically save the reviews as well");
			System.out.println("Reviews start here@ "+tempCourse.getReviews());
			session.save(tempCourse);

			

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
