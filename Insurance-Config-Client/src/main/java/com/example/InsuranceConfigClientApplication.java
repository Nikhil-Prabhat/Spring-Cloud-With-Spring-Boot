package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/*
 * Actuator invokes config-server and config-server invokes git for the uri changes
 * Check application.properties for more info
 * */

@SpringBootApplication
@RestController
@RefreshScope
public class InsuranceConfigClientApplication {
	
	@Autowired
	@Lazy
	private RestTemplate restTemplate;
	
	@Value("${insurance.provider.url}")
	private String url;
	
	@GetMapping("/getplan")
	public List<String> getPlans()
	{
		List<String> resultList = restTemplate.getForObject(url, List.class);
		return resultList;
	}

	public static void main(String[] args) {
		SpringApplication.run(InsuranceConfigClientApplication.class, args);
	}
	
	@Bean
	public RestTemplate getTemplate()
	{
		return new RestTemplate();
	}

}
