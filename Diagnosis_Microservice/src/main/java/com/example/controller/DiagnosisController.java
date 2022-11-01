package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diagnosis")
public class DiagnosisController {
	
	@GetMapping("/getdiagnosis")
	public String getDoctorService()
	{
		return "Diagnosis Microservice Called !";
	}

}
