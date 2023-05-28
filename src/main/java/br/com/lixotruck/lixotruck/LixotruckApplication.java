package br.com.lixotruck.lixotruck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
public class LixotruckApplication{

	public static void main(String[] args) {
		SpringApplication.run(LixotruckApplication.class, args);
	}

}
