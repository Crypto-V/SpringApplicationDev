package com.vas2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vas2code.hibernate.demo.entity.Course;
import com.vas2code.hibernate.demo.entity.Instructor;
import com.vas2code.hibernate.demo.entity.InstructorDetail;
import com.vas2code.hibernate.demo.entity.Review;
import com.vas2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create a session
		Session session = factory.getCurrentSession();

		try {

			// Start the transaction
			session.beginTransaction();
			
			//create course
			Course tempCourse = new Course("The hibernate journey");
			System.out.println("vas2code: created course "+tempCourse);
			
			
			//Save the course
			System.out.println("\n Saving the course...");
			session.save(tempCourse);
			System.out.println("\n Course Saved!\n" + tempCourse);
			
			
			//create the students 
			Student student1 = new Student("Vasile","Verejan","vv@gmail.com");	
			Student student2 = new Student("Artiom","Genov","AG@gmail.com");	
			Student student3 = new Student("Andrei","Malinovski","malinovksi40@gmail.com");	
			
			//add students to the coursse
			
			tempCourse.addStudent(student1);
			tempCourse.addStudent(student2);
			tempCourse.addStudent(student3);
			
			//save the students
			System.out.println("\n Saving the students...");
			session.save(student1);
			session.save(student2);
			session.save(student3);
			System.out.println("\n Students Saved!!... \n");
			

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
