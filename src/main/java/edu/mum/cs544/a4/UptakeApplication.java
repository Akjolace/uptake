package edu.mum.cs544.a4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@SpringBootApplication
public class UptakeApplication {

	public static void main(String[] args) {
		SpringApplication.run(UptakeApplication.class, args);
	}

	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("password");
		dataSource.setUrl("jdbc:mysql://localhost:3306/uptake?useSSL=false&serverTimezone=UTC?createDatabaseIfNotExist=true");
		return dataSource;
	}
}
