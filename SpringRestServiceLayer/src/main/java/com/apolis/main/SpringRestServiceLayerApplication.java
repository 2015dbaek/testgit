package com.apolis.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.apolis")
@EnableJpaRepositories("com.apolis.dao")
@EntityScan("com.apolis.model")
public class SpringRestServiceLayerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestServiceLayerApplication.class, args);
	}

}
