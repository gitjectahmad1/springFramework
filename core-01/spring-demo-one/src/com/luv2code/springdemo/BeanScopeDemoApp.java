package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		// create a spring configuration file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		//check if they are same bean
		boolean result = (theCoach == alphaCoach);
		
		//print the results
		System.out.println("\nPointing to the same Object: " + result);
		
		System.out.println("\nMemory Location for theCoach: " + theCoach);
		
		System.out.println("\nMemory Location for alphaCoach: " + alphaCoach);
		
		// close the context
		context.close();
	}

}
