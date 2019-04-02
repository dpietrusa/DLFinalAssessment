package com.detroitlabs.DLFinalAssessment.Controller;

import com.detroitlabs.DLFinalAssessment.Model.EmpireStrikesBackWrapper;
import com.detroitlabs.DLFinalAssessment.Model.HomeWorld;
import com.detroitlabs.DLFinalAssessment.Model.MovieCharacters;
import com.detroitlabs.DLFinalAssessment.Service.SwapiWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmpireStrikesBackController {

    @Autowired
    SwapiWebService swapiWebService;

    @RequestMapping("/")
    public String returnHome(ModelMap modelMap) {
        EmpireStrikesBackWrapper empireStrikesBackWrapper = swapiWebService.fetchEmpireStrikesBack();
        modelMap.put("episodeVdetails", empireStrikesBackWrapper);

        List<String> movieCharactersUrls = new ArrayList<>();
        for (String string: empireStrikesBackWrapper.getCharacterLink()){
            movieCharactersUrls.add(string);
        }
        modelMap.put("movieCharactersUrls", movieCharactersUrls);


        List<MovieCharacters> movieCharacterObjects = new ArrayList<>();

        for (String string: movieCharactersUrls){
            movieCharacterObjects.add(swapiWebService.fetchCharacter(string));
            }

        for (int i = 0; i < movieCharacterObjects.size(); i++){
            movieCharacterObjects.get(i).setUrl(movieCharactersUrls.get(i));
        }
        modelMap.put("movieCharacterObjects", movieCharacterObjects);

        return "home";
    }

    @RequestMapping("{url}")
    public String returnCharacterDetails(@RequestParam("url") String url, ModelMap modelMap) {
        MovieCharacters movieCharacters = swapiWebService.fetchCharacter(url);
        modelMap.put("movieCharacters", movieCharacters);

        HomeWorld homeWorld = swapiWebService.fetchHomeWorld(movieCharacters.getHomeWorld());
        modelMap.put("homeWorld", homeWorld);
        return "characterdetails";
    }
}
