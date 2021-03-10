package com.mysql.publicationmanagement;

//import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication
//@ComponentScan({"com.mysql.publicationmanagement.converter","com.mysql.publicationmanagement.service","com.mysql.publicationmanagement.converterImpl","com.mysql.publicationmanagement.controller","com.mysql.publicationmanagement.serviceImpl"})
//@EnableJpaRepositories
public class PublicationmanagementApplication {

	public static void main(String[] args) {

		SpringApplication.run(PublicationmanagementApplication.class, args);
		System.out.println("Welcome to Publication");

	/*	String charRange="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String shortId = RandomStringUtils.random(8,charRange);
		System.out.println(shortId);*/
	}

}
