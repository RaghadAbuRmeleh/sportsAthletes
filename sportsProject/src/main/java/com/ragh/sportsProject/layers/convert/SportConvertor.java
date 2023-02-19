package com.ragh.sportsProject.layers.convert;

import com.ragh.sportsProject.layers.domain.Sport;
import com.ragh.sportsProject.layers.dto.SportDto;
import org.springframework.stereotype.Component;

@Component
public class SportConvertor {

    public SportDto fromDomain (Sport sport){
    return new SportDto(sport.getSportName(), sport.getAthletesNum(),sport.getSportTime(), sport.getSportPlace(),sport.isEquipmentNeeded(),sport.isIndividualOrTeam());
    }

    public Sport fromDto (SportDto sportDto){
    return new  Sport(sportDto.getSportName(), sportDto.getAthletesNum(),sportDto.getSportTime(), sportDto.getSportPlace(),sportDto.isEquipmentNeeded(),sportDto.isIndividualOrTeam());
    }
}
