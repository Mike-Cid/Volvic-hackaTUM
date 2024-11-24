package com.volvic20.Volvic20.service;

import com.volvic20.Volvic20.models.GoogleAPI.payload.*;
import com.volvic20.Volvic20.models.GoogleAPI.payload.Vehicle;
import com.volvic20.Volvic20.models.GoogleAPI.response.DataGoogle;
import com.volvic20.Volvic20.models.GoogleAPI.response.Route;
import com.volvic20.Volvic20.models.GoogleAPI.response.Visit;
import com.volvic20.Volvic20.models.TSystemsAPI.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.*;

@Service
public class FetchDataService {

    @Autowired
    private WebClient webClient;

    @Autowired
    private RoutingService routingService;

    Map<Integer, String> relateIdCustomer = new HashMap<>();
    Map<Integer, String> relateIdVehicle = new HashMap<>();

    private Scenario fetchScenario() {
        // Llamar backend :8080 post crear scenario, retorna Scenario
        String url = "http://34.107.87.109:8080/scenario/create";
        return webClient.post()
                .uri(url)
                .bodyValue(new ScenarioInitializer(new Random().nextInt(50), new Random().nextInt(50)))
                .retrieve()
                .bodyToMono(Scenario.class)
                .block();
    }

    public Scenario kickStart(){
        String url = "http://34.107.87.109:8090/Scenarios/initialize_scenario";
        Scenario scenario = fetchScenario();
        List<Customer> customers = scenario.getCustomers();
        List<com.volvic20.Volvic20.models.TSystemsAPI.Vehicle> vehicles = scenario.getVehicles();
        for(int i=0;i<scenario.getCustomers().size();i++){
            relateIdCustomer.put(i,customers.get(i).getId());
        }

        for(int i=0;i<scenario.getVehicles().size();i++){
            relateIdVehicle.put(i,vehicles.get(i).getId());
        }

        webClient.post()
                .uri(url)
                .bodyValue(scenario)
                .retrieve()
                .onStatus(status -> status.is4xxClientError() || status.is5xxServerError(),
                        response -> response.bodyToMono(String.class)
                                .flatMap(body -> Mono.error(new RuntimeException("Error en la solicitud: " + body))))
                .bodyToMono(String.class)
                .block();
        return scenario;
    }

    public Matchings getMatchings(Payload payload){
        DataGoogle dg = routingService.getData(payload);
        List<Route> routes = dg.getRoutes();
        Set<Matching> machingsSet = new HashSet<>();
        for(Route route: routes){
            if(route.getVisits() == null)
                continue;
            int vehicleIndex = route.getVehicleIndex();
            for(Visit visit: route.getVisits()){
                if(visit.isPickup())
                    machingsSet.add(new Matching(relateIdVehicle.get(vehicleIndex),relateIdCustomer.get(visit.getShipmentIndex())));
            }
        }

        List<Matching> machingList = machingsSet.stream().toList();
        return new Matchings(machingList);
    }

    public Matchings matchRide(String scenarioId, Matchings vehicles){
        System.out.println(vehicles.toString());
        String url = "http://34.107.87.109:8090/Scenarios/update_scenario/"+scenarioId;
            webClient.put()
                    .uri(url)
                    .bodyValue(vehicles)
                    .retrieve()
                    .bodyToMono(Void.class)
                    .block();

        return vehicles;
    }

    public Payload generatePayload(Scenario scenario){
        List<Shipment> shipments = new ArrayList<>();
        for(Customer x: scenario.getCustomers())
        {
            shipments.add(new Shipment(List.of(new Location(new ArrivalLocation(x.getCoordX(),x.getCoordY()))),List.of(new Location(new ArrivalLocation(x.getDestinationX(),x.getDestinationY()))),new LoadDemand(new WeightKg(1))));
        }

        List<Vehicle> vehicles = new ArrayList<>();
        for(com.volvic20.Volvic20.models.TSystemsAPI.Vehicle vehicle: scenario.getVehicles())
        {
            vehicles.add(new Vehicle(new ArrivalLocation(vehicle.getCoordX(),vehicle.getCoordY()),1,new LoadLimit(new WeightKg_Vehicle(1))));
        }

        return new Payload(new Model(shipments,vehicles));
    }
}
