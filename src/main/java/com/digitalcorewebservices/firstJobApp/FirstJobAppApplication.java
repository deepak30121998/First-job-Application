package com.digitalcorewebservices.firstJobApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;

@SpringBootApplication
@EntityScan("com.digitalcorewebservices")
public class FirstJobAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstJobAppApplication.class, args);
	}

}
