/**
 * Main entry point for the backend FactoryOps Spring Boot API.
 * 
 * This file contains the Spring Boot application class serving as the entry
 * point for the application.
 * 
 * The routes' documentation is available on: http://127.0.0.1:8080/swagger-ui.html
 */

package com.factoryops.factoryops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FactoryopsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FactoryopsApplication.class, args);
	}

}
