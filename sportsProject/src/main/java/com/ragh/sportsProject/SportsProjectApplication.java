package com.ragh.sportsProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class  SportsProjectApplication {

	public static void main(String[] args) {
	/*	DataSource source = new SimpleDriverDataSource();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(source);
		SportRepository sportRepository = new SportRepository(jdbcTemplate);
		sportRepository.getSport(4L);*/

		SpringApplication.run(SportsProjectApplication.class, args);
	}

}
