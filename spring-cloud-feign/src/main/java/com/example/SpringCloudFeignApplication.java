package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.client.UserClient;
import com.example.dto.UserResponse;

@SpringBootApplication
@RestController
@EnableFeignClients
public class SpringCloudFeignApplication {
	
	@Autowired
	private UserClient userClient;
	
	@GetMapping("/users")
	public List<UserResponse> getAllUsers()
	{
		return userClient.getAllUsers();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFeignApplication.class, args);
	}

}
