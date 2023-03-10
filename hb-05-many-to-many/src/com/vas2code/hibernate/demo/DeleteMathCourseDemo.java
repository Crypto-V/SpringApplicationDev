package com.vas2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vas2code.hibernate.demo.entity.Course;
import com.vas2code.hibernate.demo.entity.Instructor;
import com.vas2code.hibernate.demo.entity.InstructorDetail;
import com.vas2code.hibernate.demo.entity.Review;
import com.vas2code.hibernate.demo.entity.Student;

public class DeleteMathCourseDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		// Create a session
		Session session = factory.getCurrentSession();

		try {

			// Start the transaction
			session.beginTransaction();

	
			int theId = 19;
			//Get the English course from DB
			Course tempCourse = session.get(Course.class, theId);
			System.out.println("We have this course: "+ tempCourse);
			
			//delete the course
			System.out.println("\n Deleting the course! \n "+ tempCourse);
			session.delete(tempCourse);
			System.out.println("\n Course was deleted! \n "+ tempCourse);
			
			
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
