package com.glassdoorbi.glassdoorbi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication
public class GlassdoorbiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlassdoorbiApplication.class, args);
	}

}


