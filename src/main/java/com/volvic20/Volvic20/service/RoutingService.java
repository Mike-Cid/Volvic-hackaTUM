package com.volvic20.Volvic20.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.volvic20.Volvic20.models.GoogleAPI.payload.*;
import com.volvic20.Volvic20.models.GoogleAPI.response.DataGoogle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class RoutingService {
    @Autowired
    private WebClient webClient;

    public DataGoogle getData(Payload payload) {
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