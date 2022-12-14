package com.upe.dce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.upe.dce.api.dtos.DTOConverter;

@SpringBootApplication
public class DceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DceApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DTOConverter localConversorBean() {
		return new DTOConverter();
	}
}
