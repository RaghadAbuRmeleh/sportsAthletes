package com.ragh.sportsProject.layers.appevent;

import com.ragh.sportsProject.layers.domain.Sport;
import com.ragh.sportsProject.layers.repository.SportRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationReady {

    private SportRepository sportRepository;

    public ApplicationReady(SportRepository sportRepository) {
        this.sportRepository = sportRepository;

    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup(){
        Sport sport = sportRepository.getSport(1L);
        System.out.println(sport.toString());
    }
}
