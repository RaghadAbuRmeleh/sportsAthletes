package com.ragh.sportsProject.layers.config;


//store META info
// instruction
import com.ragh.sportsProject.layers.convert.SportConvertor;
import com.ragh.sportsProject.layers.domain.Sport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


@Configuration
public class ApplicationConfig {

    @Bean
    @Primary
    public  String myString2 (){
        return "hello agaaaaaaain ragh from config";
    }

    @Bean("hi1")
    public  String myString1 (){
        return "hello ragh from config";
    }


    @Bean
    public  String myString3 (){
        return "hello for the third time from config";
    }
    @Bean
    public RowMapper<Sport> sportRowMapper1 (){
        return new BeanPropertyRowMapper<>(Sport.class);
    }
   /* @Bean
    public RowMapper<Sport> sportRowMapper2 (){
        return new BeanPropertyRowMapper<>(Sport.class);
    }*/

    /*public SportConvertor sportConvertor (){
        return new SportConvertor();
    }*/

}
