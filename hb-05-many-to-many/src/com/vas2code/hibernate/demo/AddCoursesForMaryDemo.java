package com.vas2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vas2code.hibernate.demo.entity.Course;
import com.vas2code.hibernate.demo.entity.Instructor;
import com.vas2code.hibernate.demo.entity.InstructorDetail;
import com.vas2code.hibernate.demo.entity.Review;
import com.vas2code.hibernate.demo.entity.Student;

public class AddCoursesForMaryDemo {

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
			System.out.println("\n Student created! " + student);
			System.out.println(
					"\n List of the current courses that belong to the student " + student.getCourses().toString());

			// create more courses
			Course course1 = new Course("Computer Science");
			Course course2 = new Course("Informatin Technology");
			Course course3 = new Course("|Arts");

			// add Vasile to those courses
			System.out.println("\n Adding the courses");
			student.addCourse(course1);
			student.addCourse(course2);
			student.addCourse(course3);
			
//			course1.addStudent(student);
//			course2.addStudent(student);
//			course3.addStudent(student);

			// save the courses
			System.out.println("\n Saving the courses");
			session.save(course1);
			session.save(course2);
			session.save(course3);
			System.out.println(
					"\n List of the student courses " + student.getCourses().toString());

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
