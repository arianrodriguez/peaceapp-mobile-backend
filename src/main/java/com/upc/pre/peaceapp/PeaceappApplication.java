package com.upc.pre.peaceapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PeaceappApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeaceappApplication.class, args);
	}

}
