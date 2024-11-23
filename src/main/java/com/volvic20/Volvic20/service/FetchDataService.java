package com.volvic20.Volvic20.service;

import com.volvic20.Volvic20.models.TSystemsAPI.Matchings;
import com.volvic20.Volvic20.models.TSystemsAPI.Scenario;
import com.volvic20.Volvic20.models.TSystemsAPI.ScenarioInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Random;

@Service
public class FetchDataService {

    @Autowired
    private WebClient webClient;
    private Scenario fetchScenario() {
        // Llamar backend :8080 post crear scenario, retorna Scenario
        String url = "http://localhost:8080/scenario/create";
        return webClient.post()
                .uri(url)
                .bodyValue(new ScenarioInitializer(new Random().nextInt(50), new Random().nextInt(50)))
                .retrieve()
                .bodyToMono(Scenario.class)
                .block();
    }

    public Scenario kickStart(){
        String url = "http://localhost:8090/Scenarios/initialize_scenario";
        Scenario scenario = fetchScenario();
        System.out.println(scenario.toString());
        webClient.post()
                .uri(url)
                .bodyValue(scenario)
                .retrieve()
                .bodyToMono(Void.class) // No response body expected
                .block();
        return scenario;
    }

    public Matchings matchRide(String scenarioId, Matchings vehicles){
        System.out.println(vehicles.toString());
        String url = "http://localhost:8090/Scenarios/update_scenario/"+scenarioId;
            webClient.put()
                    .uri(url)
                    .bodyValue(vehicles)
                    .retrieve()
                    .bodyToMono(Void.class)
                    .block();

        return vehicles;
    }
}
