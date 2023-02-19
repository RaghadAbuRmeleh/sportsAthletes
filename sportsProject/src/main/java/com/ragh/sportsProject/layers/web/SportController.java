package com.ragh.sportsProject.layers.web;


import com.ragh.sportsProject.layers.dto.SportDto;
import com.ragh.sportsProject.layers.service.SportService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//API
@RestController
@RequestMapping("/sports")
public class SportController {
    private SportService sportService;
    public SportController(SportService sportService) {
        this.sportService = sportService;
    }


    @RequestMapping (method = RequestMethod.GET, path = "/{sport_id}")
    //get method to my url it should return a sport by id
    public SportDto getSport (@PathVariable Long sport_id){

        return sportService.getSport(sport_id);
    }

    @RequestMapping (method = RequestMethod.GET)
    public List<SportDto> getSports (){
        return sportService.getSports();
    }

    @RequestMapping(method = RequestMethod.POST) //POST FOR SAVE
   @ResponseStatus (HttpStatus.CREATED)
    public SportDto createSport (@RequestBody SportDto sportDto){
        return  sportService.createSport(sportDto);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{sport_id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public void deleteSport (@PathVariable Long sport_id){
        sportService.deleteSport(sport_id);
    }

    @RequestMapping(method = RequestMethod.PATCH, path = "/{sport_id}")
    @ResponseStatus (HttpStatus.ACCEPTED)
    public SportDto updateSport (@PathVariable long sport_id, @RequestBody SportDto sportDto){
        return  sportService.updateSport(sport_id,sportDto);
    }


}
