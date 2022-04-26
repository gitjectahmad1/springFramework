package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;


public class CreateDemo {

	public static void main(String[] args) {
	
		// create a session factory
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .buildSessionFactory();
		
		// create a session 
		Session session = factory.getCurrentSession();
		
		try {		
			/*	
			// create the objects 
			Instructor tempInstructor = 
					new Instructor("Chad", "Derby", "derby@luv2code.com");
			
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail(
					  "http://www.luv2code.com/youtube",
					  "Luv 2 code!!!");
				
		*/				
			
			// create the objects 
			Instructor tempInstructor = 
				 new Instructor("Madhu", "Patel", "madhu@luv2code.com");
						
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail(
						"http://www.youtube.com",
							"Guiter");
								
	
			// associate the objects 
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			//
			// Note:This will ALSO save the details object
			// because of cascadeType.ALL
			//
			System.out.println("Saving Instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			// commit the transaction 
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
		

	}

}
