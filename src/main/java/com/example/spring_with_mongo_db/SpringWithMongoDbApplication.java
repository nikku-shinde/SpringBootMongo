package com.example.spring_with_mongo_db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.spring_with_mongo_db.repository.StudentRepository;


//https://o7planning.org/11773/spring-boot-and-mongodb

@SpringBootApplication
@EnableMongoRepositories()
public class SpringWithMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWithMongoDbApplication.class, args);
	}

}
