package com.vas2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vas2code.hibernate.demo.entity.Instructor;
import com.vas2code.hibernate.demo.entity.InstructorDetail;
import com.vas2code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		// Create a session
		Session session = factory.getCurrentSession();

		try {

			//Create the objects
			Instructor tempInstructor = new Instructor("Madhu","Pateu","madthuhuhuh@gmail.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("madhu_notsure.com","singing");
					
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
			factory.close();
		}
	}

}
