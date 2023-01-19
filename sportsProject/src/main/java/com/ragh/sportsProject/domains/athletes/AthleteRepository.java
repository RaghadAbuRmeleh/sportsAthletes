package com.ragh.sportsProject.domains.athletes;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//communication between data storage
@Repository
public class AthleteRepository {

   private JdbcTemplate jdbcTemplate;

    public AthleteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public  Object getAthlete(Long id ){
        return null;
    }
}
