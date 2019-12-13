package edu.mum.cs544.a4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
//@ComponentScan(basePackages = {"edu.mum.cs544.a4.controller"})
public class UptakeApplication {

	public static void main(String[] args) {
		SpringApplication.run(UptakeApplication.class, args);
	}

	
}
