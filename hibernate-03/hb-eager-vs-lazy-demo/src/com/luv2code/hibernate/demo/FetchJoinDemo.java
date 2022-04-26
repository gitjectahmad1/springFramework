package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;


public class FetchJoinDemo {

	public static void main(String[] args) {
	
		// create a session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Course.class)
								 .buildSessionFactory();
		
		// create a session 
		Session session = factory.getCurrentSession();
		
		try {		
			// start a transaction
			session.beginTransaction();
			
			// option 2: Hibernate query from HQL 
			
			// get the instructor from db
			int theId = 1;
			
			Query<Instructor> query = 
					session.createQuery("select i from Instructor i "
							+ "JOIN FETCH i.courses "
							+  "where i.id =:theInstructorId",
							Instructor.class);
			
			// set parameter on the query 
			query.setParameter("theInstructorId", theId);
			
			// execute the update 
			Instructor tempInstructor = query.getSingleResult();
			
			System.out.println("luv2code: Instructor: " + tempInstructor);
			
			
			// commit the transaction 
			session.getTransaction().commit();
			
			// close the session
			session.close();
			
			System.out.println("\nluv2code: The session is now closed!\n");

			// get the course for the instructor 
			System.out.println("Courses: " + tempInstructor.getCourses());
			
			
			System.out.println("luv2code: Done!");
		}
		finally {
			// add clean up code 
			session.close();
			
			factory.close();
		}
		

	}

}
