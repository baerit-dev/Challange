package it.cinemille.multisala;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class MultisalaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultisalaApplication.class, args);
	}

}

