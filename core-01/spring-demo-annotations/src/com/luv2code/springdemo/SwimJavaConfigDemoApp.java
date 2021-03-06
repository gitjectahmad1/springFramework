package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read spring configuration  java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from the spring container
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		
		// call a method on a bean 
		System.out.println(theCoach.getDailyWorkout());
		
		// call method to get daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		// call our new test methods ... has the property values injected
		System.out.println("email: " + theCoach.getEmail());		
		System.out.println("team: " + theCoach.getTeam());
		
		
		// close the context
		context.close();

	}

}
