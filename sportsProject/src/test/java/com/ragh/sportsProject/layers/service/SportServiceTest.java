package com.ragh.sportsProject.layers.service;

import com.ragh.sportsProject.layers.convert.SportConvertor;
import com.ragh.sportsProject.layers.domain.Sport;
import com.ragh.sportsProject.layers.dto.SportDto;
import com.ragh.sportsProject.layers.exceptions.DataNotFoundException;
import com.ragh.sportsProject.layers.repository.SportRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class SportServiceTest {

    @InjectMocks
    private SportService sportService;
    @Mock
    private SportRepository sportRepository;
    @Mock
    private  SportConvertor sportConvertor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getSport() {

//        SportService sportService = new SportService(new SportRepositoryMock(null, null), new SportConvertor());
//

        when (sportConvertor.fromDomain(any())).thenCallRealMethod();
        when(sportRepository.getSport(3L)).thenReturn(Optional.of(new Sport ("basketball", 8,60.0,"court",true,true)));
        SportDto sport = sportService.getSport(3L);

        assertNotNull(sport);
        assertEquals("basketball",sport.getSportName());
        assertEquals(8,sport.getAthletesNum());
        assertEquals(60.0,sport.getSportTime());
        assertEquals("court",sport.getSportPlace());
        assertTrue(sport.isEquipmentNeeded());
        assertTrue(sport.isIndividualOrTeam());
//        if (sport != null ){
//
//        }
//        if (sport.getSportName().equals("basketball")){
//
//        }


    }

    @Test
    void getSportThrowException() {
        DataNotFoundException dataNotFoundException = assertThrows(DataNotFoundException.class, () -> sportService.getSport(4L));
        assertEquals("Sport with id 4is not found",dataNotFoundException.getMessage());

    }

    @Test
    void updateSport() {

        when(sportRepository.getSport(15L)).thenReturn(Optional.of(new Sport ("basketball", 8,60.0,"court",true,true)));
        when(sportConvertor.fromDomain(any())).thenCallRealMethod();
        when((sportConvertor.fromDto(any()))).thenCallRealMethod();
        Sport sportToBeUpdated = new Sport("volleyball",8,60.0,"court",true,true);
        when(sportRepository.updateSport(15L, sportToBeUpdated)).thenReturn(Optional.of(sportToBeUpdated));
        SportDto updatedSport =   sportService.updateSport(15L,new SportDto("volleyball",8,60.0,"court",true,true));

        assertNotNull(updatedSport);
        assertEquals("volleyball",updatedSport.getSportName());
        assertEquals(8,updatedSport.getAthletesNum());
        assertEquals(60.0,updatedSport.getSportTime());
        assertEquals("court",updatedSport.getSportPlace());
        assertTrue(updatedSport.isIndividualOrTeam());
        assertTrue(updatedSport.isEquipmentNeeded());
    }

    @Test
    void updateSportAndSportDoesNotExist() {

        when(sportRepository.getSport(99L)).thenReturn(Optional.empty());
        DataNotFoundException dataNotFoundException =  assertThrows(DataNotFoundException.class, () ->  sportService.updateSport(15L,new SportDto("volleyball",8,60.0,"court",true,true)));
        assertEquals("Sport with id 99 is not found",dataNotFoundException.getMessage());
        verify(sportRepository, never()).updateSport(anyLong(),any());
    }

    ///////ooolddd
//    static class SportRepositoryMock extends SportRepository {
//        public SportRepositoryMock (JdbcTemplate jdbcTemplate, RowMapper<Sport> sportRowMapper1){
//            super(jdbcTemplate,sportRowMapper1);
//        }
//
//        @Override
//        public Optional<Sport> getSport(Long sport_id){
//            if (sport_id == 3L){
//                return  Optional.of(new Sport ("basketball", 8,60.0,"court",true,true));
//            }
//            return  Optional.empty();
//        }
//
//
//        @Override
//        public Optional<Sport> updateSport(Long sport_id, Sport sport) {
//
//            return super.updateSport(sport_id,sport);
//        }
//    }
}