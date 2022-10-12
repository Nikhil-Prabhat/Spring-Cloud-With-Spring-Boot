package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
/*
 * Actuator invokes config-server and config-server invokes git for the uri changes
 * */

@SpringBootApplication
@EnableConfigServer
public class InsuranceConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceConfigServerApplication.class, args);
	}

}
