package com.evosoft.javasetraining.webshopengine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.evosoft.javasetraining.webshopengine"})
public class WebshopEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebshopEngineApplication.class, args);
	}

}
