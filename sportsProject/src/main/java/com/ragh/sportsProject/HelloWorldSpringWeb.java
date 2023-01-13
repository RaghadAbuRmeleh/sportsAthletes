package com.ragh.sportsProject;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
public class HelloWorldSpringWeb {

    @GetMapping
    public String getHelloWorld () {
        return "Hello World from Raghad";
    }

}
