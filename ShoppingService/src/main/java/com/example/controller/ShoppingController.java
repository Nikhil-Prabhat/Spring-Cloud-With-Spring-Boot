package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ShoppingController {

	@Autowired
	private RestTemplate restTemplate;

	public static String URL = "http://PAYMENT-SERVICE/payment-provider/paynow/";

	@GetMapping("/shopping-payment/{price}")
	public String invokePaymentService(@PathVariable int price) {
		URL += price;
		return restTemplate.getForObject(URL, String.class);
	}

}
