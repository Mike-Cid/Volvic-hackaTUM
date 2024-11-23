package com.volvic20.Volvic20.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.volvic20.Volvic20.models.GoogleAPI.response.DataGoogle;
import com.volvic20.Volvic20.service.RoutingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoutingController {
    @Autowired
    RoutingService routingService;
    @PostMapping("/routing")
    public DataGoogle routing() throws JsonProcessingException {
        return routingService.getData();
    }
}
