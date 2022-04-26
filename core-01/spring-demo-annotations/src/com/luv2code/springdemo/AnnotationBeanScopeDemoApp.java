package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
	
		// read the spring config file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Retrieve the bean from the spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		// check the result if they are same
		boolean result = (theCoach == alphaCoach);
		
		//print out the result
		System.out.println("\nPointing to the same object: " + result);
		
		System.out.println("\nMemory Location for theCoach: " + theCoach);
		
		System.out.println("\nMemory Location for alphaCoach: " + alphaCoach + "\n");
		
		// close the context
		context.close();

	}

}
