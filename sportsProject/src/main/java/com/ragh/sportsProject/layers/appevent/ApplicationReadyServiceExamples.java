package com.ragh.sportsProject.layers.appevent;

import com.ragh.sportsProject.layers.dto.SportDto;
import com.ragh.sportsProject.layers.exceptions.ApplicationException;
import com.ragh.sportsProject.layers.exceptions.SemanticException;
import com.ragh.sportsProject.layers.service.SportService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ApplicationReadyServiceExamples {


    private SportService sportService;

    public ApplicationReadyServiceExamples(SportService sportService) {
        this.sportService = sportService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup(){
        try {
            SportDto sport  = sportService.createSport(new SportDto("volleyball", 8, -60.0,"court",true,true));
            System.out.println(sport);
        } catch (SemanticException e) {
            System.out.println(e.getMessage());
        }

        try {
            sportService.deleteSport(2L);
        } catch (ApplicationException e) {
            System.out.println(e.getMessage());
        }
    }
}
