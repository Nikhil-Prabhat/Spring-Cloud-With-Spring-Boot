package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/chatbook-application")
public class ChatbookApplication {
	
	@Value("${server.port}")
	public String portNo;
	
	@GetMapping("/chat")
	public String chatNow()
	{
		return "Application is up on port : " + portNo;
	}

	public static void main(String[] args) {
		SpringApplication.run(ChatbookApplication.class, args);
	}

}
