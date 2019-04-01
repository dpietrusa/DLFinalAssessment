package com.detroitlabs.DLFinalAssessment.Controller;

import com.detroitlabs.DLFinalAssessment.Model.EmpireStrikesBackWrapper;
import com.detroitlabs.DLFinalAssessment.Service.SwapiWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmpireStrikesBackController {

    @Autowired
    SwapiWebService swapiWebService;

    @RequestMapping("/")
    @ResponseBody
    public String returnHome() {
        EmpireStrikesBackWrapper empireStrikesBackWrapper = swapiWebService.fetchEmpireStrikesBack();
        return empireStrikesBackWrapper.getTitle();
    }
}
