package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	@GetMapping("/getdm")
	public String getDoctor()
	{
		return "Doctor MicroService Called !";
	}
	
	@GetMapping("/getum/{name}")
	public String getWelcomMessageForUser(@PathVariable String name)
	{
		String message = "Hi "+ name + " , Welcome to Doctor's MicroService !";
		return message;
	}

}
