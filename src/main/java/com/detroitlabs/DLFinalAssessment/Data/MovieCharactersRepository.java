package com.detroitlabs.DLFinalAssessment.Data;

import com.detroitlabs.DLFinalAssessment.Model.EmpireStrikesBackWrapper;
import com.detroitlabs.DLFinalAssessment.Model.MovieCharacters;
import com.detroitlabs.DLFinalAssessment.Service.SwapiWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieCharactersRepository {

    @Autowired
    private SwapiWebService swapiWebService;

    public List<MovieCharacters> getMovieCharacters() {

        EmpireStrikesBackWrapper empireStrikesBackWrapper = swapiWebService.fetchEmpireStrikesBack();
        List<String> movieCharactersUrls = new ArrayList<>();
        for (String string : empireStrikesBackWrapper.getCharacterLink()) {
            movieCharactersUrls.add(string);
        }

        List<MovieCharacters> movieCharacters = new ArrayList<>();

        for (String string : movieCharactersUrls) {
            movieCharacters.add(swapiWebService.fetchCharacter(string));
        }

        for (int i = 0; i < movieCharacters.size(); i++) {
            movieCharacters.get(i).setUrl(movieCharactersUrls.get(i));
        }
        return movieCharacters;
    }


}
