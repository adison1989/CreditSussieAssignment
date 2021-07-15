package com.assignment.creditSussie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.assignment.creditSussie" })
public class CreditSussieApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditSussieApplication.class, args);
	}

}
