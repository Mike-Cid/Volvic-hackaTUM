package com.volvic20.Volvic20.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.volvic20.Volvic20.models.GoogleAPI.payload.*;
import com.volvic20.Volvic20.models.GoogleAPI.payload.response.DataGoogle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class RoutingService {
    @Autowired
    private WebClient webClient;

    public DataGoogle getData() throws JsonProcessingException {
        ArrivalLocation arrivalLocationPickup = new ArrivalLocation(37.73881799999999,-122.4161);
        Location locationPickup = new Location(arrivalLocationPickup);

        ArrivalLocation arrivalLocationDeliveries = new ArrivalLocation(37.79581,-122.4218856);
        Location locationDeliveries = new Location(arrivalLocationDeliveries);

        LoadDemand loadDemand = new LoadDemand(new WeightKg(1));

        Shipment shipments = new Shipment(List.of(locationPickup), List.of(locationDeliveries), loadDemand);


        ArrivalLocation startArrivalLocation = new ArrivalLocation(37.73881799999999,-122.4161);
        ArrivalLocation endArrivalLocation = new ArrivalLocation(37.73881799999999,-122.4161);
        Vehicle vehicles = new Vehicle(startArrivalLocation,endArrivalLocation,1,new LoadLimit(new EquipmentRackStorage(1)));
        Model model = new Model(List.of(shipments),List.of(vehicles),"2024-02-13T00:00:00.000Z","2024-02-14T00:00:00.000Z");
        Payload payload = new Payload(model);

        System.out.println(new ObjectMapper().writeValueAsString(payload));
        String bearerToken = "ya29.a0AeDClZA2zeiWlK5xC_8TlTZoEELV6JEzwHUv1ZkN7aV4uWjWAjKsByEbOwBgR3j5eERKStOfjTktviFHyxVQwQ3J_2l6v_Q8oEY9qvntrnvP1r4Kng3nNtJ1wxFIn3ti0yoKIaVV9Hvi0zt-iQdrIu3N4WrOgTfLwJlfXMmql9dSQiXntaTj6xxfN57JBlbugNKd49eXqFA6SsB0B7ils2locytGouwMxpeN5rBKi7DQClGL_k5A7-Y-BLZL1kILh7EmUkPQtCSaiNIAcc6sQ0n2WnNOLbLSgTTqQ0AXKoKPsl_k1IW6t0ugsVtLcd9bE-wsz-M7S9sYCEjERGwdM88aTjoAxbK5EU9jnBnN2GI3_OKLeWDXLzL7DxHWBVo1y14XNDO_LbGv8GhnNo9l5cGww2KJbA-0J9F5QQaCgYKAd0SARESFQHGX2Mi-3zDBvafLe5xVvvNJQqkDQ0429";
        return webClient.post()
                .uri("https://routeoptimization.googleapis.com/v1/projects/hackathum24mun-26:optimizeTours")
                .headers(headers -> headers.setBearerAuth(bearerToken)) // Agrega el Bearer Token
                .bodyValue(payload)
                .retrieve()
                .bodyToMono(DataGoogle.class)
                .block();
    }
}