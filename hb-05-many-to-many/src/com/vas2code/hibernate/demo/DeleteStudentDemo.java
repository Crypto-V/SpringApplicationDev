package com.vas2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vas2code.hibernate.demo.entity.Course;
import com.vas2code.hibernate.demo.entity.Instructor;
import com.vas2code.hibernate.demo.entity.InstructorDetail;
import com.vas2code.hibernate.demo.entity.Review;
import com.vas2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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

			// get the student Vasile from the db
			int theId = 1;
			Student student = session.get(Student.class, theId);
			System.out.println("\n Student extracted! " + student);
			System.out.println(
					"\n List of the current courses that belong to the student \n" + student.getCourses());

			//Delete student from db
			session.delete(student);
			System.out.println("Student "+student+"was remove from database.");
			
			
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
