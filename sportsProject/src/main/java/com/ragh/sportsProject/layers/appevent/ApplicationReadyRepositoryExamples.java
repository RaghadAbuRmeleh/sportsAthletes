package com.ragh.sportsProject.layers.appevent;

import com.ragh.sportsProject.layers.domain.Sport;
import com.ragh.sportsProject.layers.repository.SportRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

//@Component
public class ApplicationReadyRepositoryExamples {

    private SportRepository sportRepository;

    public ApplicationReadyRepositoryExamples(SportRepository sportRepository) {
        this.sportRepository = sportRepository;

    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
       Sport sport = sportRepository.getSport(3L).get();
        System.out.println(sport.toString());


        Sport sportToBeCreated = new Sport("basketball", 8, 60.0,"court",true,true);
        Sport createdSport =  sportRepository.createSport(sportToBeCreated);
        System.out.println(createdSport);

        Sport sportToBeUpdated = new Sport("basketball UPD", 10, 60.0,"court",true,true);
        Sport updatedSport =  sportRepository.updateSport(3L,sportToBeUpdated).get();
        System.out.println(updatedSport);



        sportRepository.deleteSport(2L);


    }
}
