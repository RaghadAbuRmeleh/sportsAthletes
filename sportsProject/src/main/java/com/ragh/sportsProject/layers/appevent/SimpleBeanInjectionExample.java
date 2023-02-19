package com.ragh.sportsProject.layers.appevent;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

//@Component
public class SimpleBeanInjectionExample {

    private  String myString ;


    public SimpleBeanInjectionExample(@Qualifier ("hi1") String myString) {
        this.myString = myString;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        System.out.println("String " + myString);
        }
    }


