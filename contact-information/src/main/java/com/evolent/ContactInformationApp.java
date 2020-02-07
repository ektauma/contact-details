package com.evolent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAutoConfiguration
@EnableAspectJAutoProxy
@ComponentScan(basePackages="com.evolent.*") 
@EntityScan(basePackages="com.evolent.entity") 
public class ContactInformationApp {

	public static void main(String[] args) {
		SpringApplication.run(ContactInformationApp.class, args);
	}

}
