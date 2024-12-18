package com.volvic20.Volvic20.controllers;

import com.volvic20.Volvic20.models.GoogleAPI.payload.Payload;
import com.volvic20.Volvic20.models.TSystemsAPI.Matchings;
import com.volvic20.Volvic20.models.TSystemsAPI.Matching;
import com.volvic20.Volvic20.models.TSystemsAPI.Scenario;
import com.volvic20.Volvic20.service.FetchDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;


@RestController
@RequestMapping("/our_api")
public class ScenarioController {


    @Autowired
    private FetchDataService fetchDataService;

    @PostMapping("/create")
    public Matchings createScenario() {
        Scenario res = fetchDataService.kickStart();
        Payload pay = fetchDataService.generatePayload(res);
        return fetchDataService.getMatchings(pay);
    }

}
