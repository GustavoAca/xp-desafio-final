package com.xp.desafio_final;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.xp.desafio_final.model.domain")
@EnableJpaRepositories(basePackages = {"com.xp.desafio_final.model.repositories"})
public class DesafioFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioFinalApplication.class, args);
	}

}
