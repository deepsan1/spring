package com.example;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



//@EnableJpaRepositories("com.example.repo")
//@ComponentScan(basePackages = { "com.example.repo" })
//@EntityScan("com.example.Entity")  
@EnableJpaRepositories("com.example")
@ComponentScan(basePackages = { "com.example.service","com.example.controller","com.example.repo","com.example.Entity" })
@EntityScan("com.example.Entity")   
//@EnableAutoConfiguration
@SpringBootApplication()
public class MyWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyWebApplication.class, args);
	}

	
}