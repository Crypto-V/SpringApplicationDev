package com.vas2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vas2code.hibernate.demo.entity.Course;
import com.vas2code.hibernate.demo.entity.Instructor;
import com.vas2code.hibernate.demo.entity.InstructorDetail;
import com.vas2code.hibernate.demo.entity.Student;

public class CreateInstructorDemo {

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

			//Create the objects
			Instructor tempInstructor = new Instructor("Susan","Public","susan.p@gmail.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("susanWorld.com","games");
					
			//Associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// Start or begining the transaction
			session.beginTransaction();
			
			
			//Save the instructor
			//
			//Note: this will save the instructor details as well Cascade type all
			System.out.println("Saving instructor: "+tempInstructor);
			session.save(tempInstructor);
			

			// commit the transaction
			System.out.println("Commit the transaction");
			session.getTransaction().commit();
			System.out.println("Done!!");

		} finally {
			//add clean up code
			session.close();
			factory.close();
		}
	}

}
