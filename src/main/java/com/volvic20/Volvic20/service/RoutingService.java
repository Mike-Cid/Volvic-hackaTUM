package com.volvic20.Volvic20.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.volvic20.Volvic20.models.GoogleAPI.payload.*;
import com.volvic20.Volvic20.models.GoogleAPI.response.DataGoogle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class RoutingService {
    @Autowired
    private WebClient webClient;

    public DataGoogle getData(Payload payload) {
        try {
            // Log the payload
            ObjectMapper objectMapper = new ObjectMapper();
            String payloadJson = objectMapper.writeValueAsString(payload);
            System.out.println("Payload: " + payloadJson);

            String bearerToken = "ya29.a0AeDClZBwPjGsMwNOYADXEuMFW0U3Lcy22iLYGZ9h55e5M3rVX5joW89HK3OHLGkX-JoBCcuti6lsg-_8OmARiQKcCr4KYBnFN5RP14fbnRssfIYuJBYrK" +
                    "l5bLpRrLB-fN59KZm5s51_meK4-3CGsbwACG3zWlZDMrhq08FQlJJr9Qxa4PYo_5lw0U5CR0OSLm_jWH-lvUPJzw_Gf3B_KgckSlClVeaa7fM0XlB9O1a4Zr8auezo1x7SYrrBonRY2TX" +
                    "4Yc9NPA3ZPt_xee4-sgNsAOYonwNYfeDFHSVJI-cix96US91FdUYigqfJJJ5KLpLmDp7H8VSREftg4-SUKmyuqy6xE7zBFSy5luz2wU2cUvvAauHFM-SxayqnbTPH9RBHsN58ufWIV_aMwEoQQm" +
                    "VTq5dMRuelzdksgaCgYKAVYSARESFQHGX2MiSWxeuC5E3Q4YMdgtuXl35w0427";
            return webClient.post()
                    .uri("https://routeoptimization.googleapis.com/v1/projects/hassio-stt-408500:optimizeTours")
                    .headers(headers -> headers.setBearerAuth(bearerToken))
                    .bodyValue(payload)
                    .retrieve()
                    .onStatus(
                            status -> status.is4xxClientError(),
                            response -> handleError(response, "4xx Client Error")
                    )
                    .onStatus(
                            status -> status.is5xxServerError(),
                            response -> handleError(response, "5xx Server Error")
                    )
                    .bodyToMono(DataGoogle.class)
                    .doOnError(e -> System.err.println("Error: " + e.getMessage()))
                    .block();

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("Error serializing payload", e);
        }
    }

    // Custom error handler
    private Mono<? extends Throwable> handleError(ClientResponse response, String errorType) {
        return response.bodyToMono(String.class)
                .flatMap(body -> {
                    System.err.println(errorType + ": " + response.statusCode());
                    System.err.println("Error Body: " + body);
                    return Mono.error(new RuntimeException(errorType + " - " + body));
                });
    }

}