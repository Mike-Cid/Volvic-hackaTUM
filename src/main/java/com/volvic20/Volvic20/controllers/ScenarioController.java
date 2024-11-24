package com.volvic20.Volvic20.controllers;

import com.volvic20.Volvic20.models.TSystemsAPI.Matchings;
import com.volvic20.Volvic20.models.TSystemsAPI.Matching;
import com.volvic20.Volvic20.models.TSystemsAPI.Scenario;
import com.volvic20.Volvic20.service.FetchDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/our_api")
public class ScenarioController {


    @Autowired
    private FetchDataService fetchDataService;

    private Matchings matchings;

    @PostMapping("/create")
    public String createScenario() {
        Scenario res = fetchDataService.kickStart();
        this.matchings = fetchDataService.getMatchings(fetchDataService.generatePayload(res));
        return res.getId();
    }

    @PostMapping("/update/{scenarioId}")
    public Matchings updateScenario(@PathVariable String scenarioId) {
        return fetchDataService.matchRide(scenarioId,matchings);
    }

    /*@GetMapping("/stats")
    public


     */
}
