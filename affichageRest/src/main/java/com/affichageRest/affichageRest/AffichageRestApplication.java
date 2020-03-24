package com.affichageRest.affichageRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class AffichageRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AffichageRestApplication.class, args);
	}

}
