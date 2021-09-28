package com.example.owasp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.owasp.models")
public class OwaspApplication {

	public static void main(String[] args) {
		SpringApplication.run(OwaspApplication.class, args);
	}

}
