package com.luv2code.springboot.demo.newmycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	// expose a "/" that return hello world
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello World! Time On the server is " + LocalDateTime.now();
	}
	
	// expose a endnew point for workout
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run a hard 5K!";
	}
	
	// expose a new endpoint for fortune
	@GetMapping("/fortune")
	public String getDailyFortune() {
		return "Today is your very lucky day!";
	}
	
}
