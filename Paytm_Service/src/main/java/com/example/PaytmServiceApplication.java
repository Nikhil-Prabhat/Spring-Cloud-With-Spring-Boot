package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/payment")
public class PaytmServiceApplication {
	
	@GetMapping("/pay")
	public String pay()
	{
		return "Payment Service Called !";
	}

	public static void main(String[] args) {
		SpringApplication.run(PaytmServiceApplication.class, args);
	}

}
