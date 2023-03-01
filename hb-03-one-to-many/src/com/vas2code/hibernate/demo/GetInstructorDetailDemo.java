package com.vas2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vas2code.hibernate.demo.entity.Instructor;
import com.vas2code.hibernate.demo.entity.InstructorDetail;
import com.vas2code.hibernate.demo.entity.Student;

public class GetInstructorDetailDemo {

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

			// Start transaction
			session.beginTransaction();
			
			//Create the instructor detail instance
			int theId = 2999;
			InstructorDetail  tempInstructorDetail = session.get(InstructorDetail.class, theId);
			
			//Print obj detail
			System.out.println("Here is the instructor detail: "+tempInstructorDetail);
			
			// Print associated instructor
			System.out.println("Here is the associated instructor:--> "+tempInstructorDetail.getInstructor());

			
			// commit the transaction
			System.out.println("Commit the transaction");
			session.getTransaction().commit();
			System.out.println("Done!!");

		} catch (Exception e){
			e.printStackTrace();
		}
		finally {
			//Connection leak issue
			session.close();
			factory.close();
		}
	}

}
