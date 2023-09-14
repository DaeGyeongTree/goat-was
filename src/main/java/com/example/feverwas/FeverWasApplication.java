package com.example.feverwas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FeverWasApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeverWasApplication.class, args);
	}

}
