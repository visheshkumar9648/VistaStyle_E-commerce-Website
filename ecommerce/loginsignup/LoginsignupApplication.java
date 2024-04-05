package com.ecommerce.loginsignup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RequestMapping("/register")

public class LoginsignupApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginsignupApplication.class, args);
	}

}
