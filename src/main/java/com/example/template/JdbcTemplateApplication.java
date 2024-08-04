package com.example.template;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log
public class JdbcTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcTemplateApplication.class, args);
	}

}
