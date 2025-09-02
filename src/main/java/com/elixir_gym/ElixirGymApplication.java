package com.elixir_gym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ElixirGymApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElixirGymApplication.class, args);
	}

}
