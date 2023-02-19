package com.ragh.sportsProject.layers.service;

import com.ragh.sportsProject.layers.convert.SportConvertor;
import com.ragh.sportsProject.layers.domain.Sport;
import com.ragh.sportsProject.layers.dto.SportDto;
import com.ragh.sportsProject.layers.exceptions.DataNotFoundException;
import com.ragh.sportsProject.layers.exceptions.SemanticException;
import com.ragh.sportsProject.layers.repository.SportRepository;
import com.ragh.sportsProject.layers.repository.SportRepositoryNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//logic
@Service
public class SportService {

private SportRepositoryNew sportRepositoryNew;

  //  private SportRepository sportRepository;
   private SportConvertor sportConvertor;
    public SportService(SportRepository sportRepository, SportConvertor sportConvertor, SportRepositoryNew sportRepositoryNew) {
      System.out.println("SportSer Cons is CALLED");
//        this.sportRepository = sportRepository;
        this.sportRepositoryNew = sportRepositoryNew;
        this.sportConvertor = sportConvertor;
    }


//    public SportService(){
//        this.sportRepository = null;
//        this.sportConvertor=null;
//    }


    public SportDto createSport( SportDto sportDto) {
        validate(sportDto);
        Sport createdSport =  sportRepositoryNew.save( sportConvertor.fromDto(sportDto));
              return  sportConvertor.fromDomain(createdSport);
    }


    public SportDto updateSport(Long sport_id, SportDto sportDto){
        checkExisting(sport_id);
        validate(sportDto);
      return   sportRepositoryNew.findById(sport_id)
                        .map(sport -> {

                          Sport sport1 =   sportConvertor.fromDto(sportDto);
                          sport1.setSport_id(sport1.getSport_id());
                          return sportRepositoryNew.save(sport1);
                        })
                .map(savedSport -> sportConvertor.fromDomain(savedSport))
                .orElseThrow(() -> new RuntimeException());

        //sportRepositoryNew.save( sportConvertor.fromDto(sportDto))
//       return  sportRepositoryNew.save(sport_id , sportConvertor.fromDto(sportDto))
//                .map( (s -> sportConvertor.fromDomain(s)))
//                .get();

    }

    public void deleteSport (Long sport_id){
        checkExisting(sport_id);
         sportRepositoryNew.deleteById(sport_id);

    }

    private void checkExisting(Long sport_id) {
//        Sport sport = sportRepository.getSport(sport_id);
//        if (sport != null) {
//            System.out.println("deleteSport is called");
//            sportRepository.deleteSport(sport_id);
//        }
//        else {
//            throw new DataNotFoundException("Sport with id " + sport_id + "is not found");
//        }
        sportRepositoryNew
                .findById(sport_id)
                .map(s -> {
                    System.out.println("CheckExisting is called");
                    return s;
                })
                .orElseThrow(() -> new DataNotFoundException("Sport with id " + sport_id + "is not found"));
    }
    private static void validate(SportDto sportDto) {
        if (sportDto.getSportTime() == null || (sportDto.getSportTime() < 1)){
            throw new SemanticException("Match time cannot be negative ");
        }
    }

    public SportDto getSport (Long sport_id){
        return sportRepositoryNew.findById(sport_id)
                .map(s -> sportConvertor.fromDomain(s))
                .orElseThrow(() -> new DataNotFoundException("Sport with id " + sport_id + "is not found"));

    }

    public List<SportDto> getSports (){
        return sportRepositoryNew.findAll()
                .stream()
                .map(sport ->  sportConvertor.fromDomain(sport))
                .toList();
    }
}
