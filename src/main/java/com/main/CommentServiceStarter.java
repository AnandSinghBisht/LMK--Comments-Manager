package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages={"com"})
@EnableMongoRepositories(basePackages="com.repository")
public class CommentServiceStarter {

	public static void main(String[] args) {
		SpringApplication.run(CommentServiceStarter.class, args);
	}
}
