package br.com.lixotruck.lixotruck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class LixotruckApplication{

	public static void main(String[] args) {
		SpringApplication.run(LixotruckApplication.class, args);
	}

}
