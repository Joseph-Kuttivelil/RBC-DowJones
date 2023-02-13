package com.rbc.assessment.dowjones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.rbc.assessment.dowjones.repository")
@EntityScan("com.rbc.assessment.dowjones.repository.entity")
@SpringBootApplication
public class DowjonesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DowjonesApplication.class, args);
	}

}
