package com.example.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class AirportServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirportServerApplication.class, args);
	}

}
