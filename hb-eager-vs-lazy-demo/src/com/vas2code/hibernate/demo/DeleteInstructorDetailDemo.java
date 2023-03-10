package com.vas2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vas2code.hibernate.demo.entity.Instructor;
import com.vas2code.hibernate.demo.entity.InstructorDetail;
import com.vas2code.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// Create a session
		Session session = factory.getCurrentSession();

		try {

			// Start transaction
			session.beginTransaction();

			// Create the instructor detail instance
			int theId = 3;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);

			// Print obj detail
			System.out.println("Here is the instructor detail: " + tempInstructorDetail);

			// Print associated instructor
			System.out.println("Here is the associated instructor:--> " + tempInstructorDetail.getInstructor());

			// Delete the instructor detail, this will cascade the delete lover the
			// instructor implementation as well
			System.out
					.println("Hey i am deleteing the tempInstructionDelete to see the cascade" + tempInstructorDetail);
			
			//remove the associated object reference when trying to delete the records from one table only
			//break b-directional link
			
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			session.delete(tempInstructorDetail);

			// commit the transaction
			System.out.println("Commit the transaction");
			session.getTransaction().commit();
			System.out.println("Done!!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Connection leak issue
			session.close();
			factory.close();
		}
	}

}
