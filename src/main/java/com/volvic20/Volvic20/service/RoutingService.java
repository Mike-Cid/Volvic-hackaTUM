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

            String bearerToken = "ya29.a0AeDClZCqzFVTDcZrhmVn9khfboKElPIbp4-uxaK3WARccZXeKE-kUPjVatGSyD8RwA5pix7Yri3cUEcE28Cy2yfesTH8UYwl4XdqhJtu52cscmT3rHMxoOu9F-fHuzuMZ1pHwVD9EW46ik0bhLbZskhGQKWOH15YRMZf-i7_y1BirRShE-maeZLioo28_qk6CQ5DESDyZ4OadZwcR4wiKcmprYxPn1X9NoUK1hgQ2hk7DgvwoKQbu_dd88Z1DhR-Atw28Zp8ATnpyFzSWZ9-0li2nHSMgA9KtScJ6PUCsH24-sHbxj-RarqCoJiMDxxeKrmWY7sZSjP-8uxaAZhfNd0uGjP2xbG7PA6zmt4uLZw_O91ArBNE45U-SbS67uZB1ztKSHpttO0aQCo96mbIiGowtXEW3wUUI_21DAaCgYKAcYSARESFQHGX2Mi6elV9RUn2uOZqLqwWFXCig0429";
            return webClient.post()
                    .uri("https://routeoptimization.googleapis.com/v1/projects/hackathum24mun-26:optimizeTours")
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