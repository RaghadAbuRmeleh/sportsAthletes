package com.ragh.sportsProject.layers.repository;
import com.ragh.sportsProject.layers.domain.Sport;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

//communication between data storage
@Repository
public class SportRepository {

    private JdbcTemplate jdbcTemplate;

    public SportRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Sport getSport (Long sport_id){
        RowMapper<Sport> rowMapper = new BeanPropertyRowMapper<>(Sport.class);
        Sport sport = jdbcTemplate.queryForObject( "select * from sports where sport_id=?", rowMapper, sport_id);
        return sport;
    }
}
