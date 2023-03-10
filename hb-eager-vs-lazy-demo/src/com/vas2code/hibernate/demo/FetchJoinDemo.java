package com.vas2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.hql.spi.id.local.LocalTemporaryTableBulkIdStrategy;
import org.hibernate.query.Query;

import com.vas2code.hibernate.demo.entity.Course;
import com.vas2code.hibernate.demo.entity.Instructor;
import com.vas2code.hibernate.demo.entity.InstructorDetail;
import com.vas2code.hibernate.demo.entity.Student;

public class FetchJoinDemo {

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

			// Start the transaction
			session.beginTransaction();

			
			int theId = 1;
			//Option 2: Hibernate query with HQL
			// get the instructor from db
			Query<Instructor> query = 
					session.createQuery("select i from Instructor i "
									+ "JOIN FETCH i.courses "
									+ "where i.id =:theInstructor",
									Instructor.class);
			
			//ser parameter on query
			query.setParameter("theInstructor", theId);

			//execute query and get instructor
			Instructor tempInstructor = query.getSingleResult();
			System.out.println("vas2code: Instructor: "+tempInstructor);
			
			// commit the transaction
			session.getTransaction().commit();
			
			session.close();
			System.out.println("\n The session is now closed!!!\n");
			System.out.println("vas2code: Courses after session close: "+tempInstructor.getCourses());
			System.out.println("vas2code: Done!!");

		} finally {
			// add clean up code
			session.close();
			factory.close();
		}
	}

}
