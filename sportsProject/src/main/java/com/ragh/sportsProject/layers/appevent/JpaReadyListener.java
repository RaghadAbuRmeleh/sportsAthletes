package com.ragh.sportsProject.layers.appevent;

import com.ragh.sportsProject.layers.domain.Sport;
import com.ragh.sportsProject.layers.repository.SportRepositoryNew;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class JpaReadyListener {

    private final SportRepositoryNew sportRepositoryNew;

    public JpaReadyListener(SportRepositoryNew sportRepositoryNew) {
        this.sportRepositoryNew = sportRepositoryNew;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doJpaWork(){
       Sport sport = sportRepositoryNew.findById(3L).get();
        System.out.println("Sport from Spring data:" + sport);
    }
}
