package com.ragh.sportsProject.layers.repository;
import com.ragh.sportsProject.layers.domain.Sport;
import com.ragh.sportsProject.layers.dto.SportDto;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

//communication between data storage
@Repository
public class SportRepository {

    private JdbcTemplate jdbcTemplate;
  private  RowMapper<Sport> rowMapper;

    public SportRepository(JdbcTemplate jdbcTemplate, RowMapper<Sport> rowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
    }

    public Optional <Sport> getSport (Long sport_id){ //RETURN SINGLE ROW BY ID
        try {
            Sport sport = jdbcTemplate.queryForObject( "select * from sports where sport_id=?", rowMapper, sport_id);
            return Optional.ofNullable(sport);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }



    public Sport createSport (Sport sport){

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO public.sports(\n" +
                    "\tsport_name, athletes_num, sport_time, sport_place, equipment_needed, individual_team)\n" +
                    "\tVALUES (?, ?, ?, ?, ?, ?)", new String[]{"sport_id"});
            preparedStatement.setString(1,sport.getSportName());
            preparedStatement.setInt(2,sport.getAthletesNum());
            preparedStatement.setDouble(3,sport.getSportTime());
            preparedStatement.setString(4,sport.getSportPlace());
            preparedStatement.setBoolean(5,sport.isEquipmentNeeded());
            preparedStatement.setBoolean(6,sport.isIndividualOrTeam());

            return preparedStatement;
        },
              keyHolder);

        long generatedKey =  keyHolder.getKey().longValue();

        return getSport(generatedKey).get();
    }

    public Optional<Sport> updateSport (Long sport_id,Sport sport){

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement = con.prepareStatement("UPDATE public.sports\n" +
                    "\tSET sport_name=?, athletes_num=?, sport_time=?, sport_place=?, equipment_needed=?, individual_team=? \n" +
                    "\tWHERE sport_id = ?;", new String[]{"sport_id"});
            preparedStatement.setString(1,sport.getSportName());
            preparedStatement.setInt(2,sport.getAthletesNum());
            preparedStatement.setDouble(3,sport.getSportTime());
            preparedStatement.setString(4,sport.getSportPlace());
            preparedStatement.setBoolean(5,sport.isEquipmentNeeded());
            preparedStatement.setBoolean(6,sport.isIndividualOrTeam());
            preparedStatement.setLong(7,sport_id);
            return preparedStatement;
        });

        return getSport(sport_id);
    }

    public void deleteSport (Long sport_id){

        jdbcTemplate.update("delete from sports where sport_id = 1");
    }

    public List<Sport> getSports (){
        return jdbcTemplate.query("select * from sports", rowMapper);
    }
}
