package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RibbonClient(name = "chatbook", configuration = RibbonConfiguration.class)
public class ChatbookUserApplication {

	@Autowired
	@Lazy
	private RestTemplate restTemplate;

	@GetMapping("/invoke")
	public String invokeChatBook() {
		
		/*
		 * We are using chatbook directly because first the request will go to the load balancer instead of the microservice
		 * Seeing chatbook, the request will be forwareded to the application.yml
		 * */
		
		String url = "http://chatbook/chatbook-application/chat";
		return restTemplate.getForObject(url, String.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ChatbookUserApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
