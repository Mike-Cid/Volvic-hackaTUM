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

    private String id;
    private String customerId;

    @Autowired
    private FetchDataService fetchDataService;

    @PostMapping("/create")
    public String createScenario() {
        Scenario res = fetchDataService.kickStart();
        id = res.getVehicles().get(0).getId();
        customerId = res.getCustomers().get(0).getId();
        System.out.println(customerId);
        System.out.println(id);
        return res.getId();
    }

    @PostMapping("/update")
    public Matchings updateScenario(@RequestBody String scenarioId) {
        System.out.println(customerId);
        System.out.println(id);
        return fetchDataService.matchRide(scenarioId, new Matchings(List.of(new Matching(id,customerId))));
    }

    /*@GetMapping("/stats")
    public

     */
}
