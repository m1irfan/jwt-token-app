package com.example.jwt_token_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class JwtTokenAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtTokenAppApplication.class, args);
	}

}
