package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@SpringBootApplication
@RestController
@EnableHystrix
public class BookMyShowApplication {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(groupKey = "bookMyShow",commandKey = "bookMyShow",fallbackMethod = "bookMyShowFallback")
	@GetMapping("/booknow")
	public String bookMyShow()
	{
		String emailServiceResponse = restTemplate.getForObject("http://localhost:8081/email/send", String.class);
		String paymentServiceResponse = restTemplate.getForObject("http://localhost:8082/payment/pay", String.class);
		return emailServiceResponse + "\n" + paymentServiceResponse;
	}
	
	@GetMapping("/booknowunsecure")
	public String bookMyShowWithoutHystrix()
	{
		String emailServiceResponse = restTemplate.getForObject("http://localhost:8081/email/send", String.class);
		String paymentServiceResponse = restTemplate.getForObject("http://localhost:8082/payment/pay", String.class);
		return emailServiceResponse + "\n" + paymentServiceResponse;
	}
	
	/*
	 * The fallback method should always have same return type as the actual method
	 * */
	
	public String bookMyShowFallback() {
		return "Service Gateway Failed... !!";
	}

	public static void main(String[] args) {
		SpringApplication.run(BookMyShowApplication.class, args);
	}

	@Bean
	public RestTemplate template()
	{
		return new RestTemplate();
	}
}
