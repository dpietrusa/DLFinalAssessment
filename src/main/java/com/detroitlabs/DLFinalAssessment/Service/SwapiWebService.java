package com.detroitlabs.DLFinalAssessment.Service;

import com.detroitlabs.DLFinalAssessment.Model.EmpireStrikesBackWrapper;
import com.detroitlabs.DLFinalAssessment.Model.MovieCharacters;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class SwapiWebService {
    public EmpireStrikesBackWrapper fetchEmpireStrikesBack() {
        System.setProperty("http.agent", "StarWars");

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://swapi.co/api/films/2", EmpireStrikesBackWrapper.class);
    }

    public MovieCharacters fetchCharacter(String url){
        System.setProperty("http.agent", "name");
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, MovieCharacters.class);

    }



}
