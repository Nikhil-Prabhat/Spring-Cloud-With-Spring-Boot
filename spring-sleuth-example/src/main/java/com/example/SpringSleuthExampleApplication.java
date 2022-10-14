package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class SpringSleuthExampleApplication {
	
	private static final Logger LOG = LoggerFactory.getLogger(SpringSleuthExampleApplication.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/getdiscount")
	public String getDiscount()
	{
		LOG.info("Discount Service Called");
		return "Added Discount 15%";
	}
	
	@GetMapping("/payment")
	public String payment()
	{
		LOG.info("Payment Service Called");
		return restTemplate.getForObject("http://localhost:8080/getdiscount", String.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSleuthExampleApplication.class, args);
	}

}
