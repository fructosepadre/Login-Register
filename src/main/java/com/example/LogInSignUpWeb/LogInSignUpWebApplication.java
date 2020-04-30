package com.example.LogInSignUpWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "*")
public class LogInSignUpWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogInSignUpWebApplication.class, args);
	}

}
