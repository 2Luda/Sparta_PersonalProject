package com.sparta.sparta_personalproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpartaPersonalProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpartaPersonalProjectApplication.class, args);
	}

}
