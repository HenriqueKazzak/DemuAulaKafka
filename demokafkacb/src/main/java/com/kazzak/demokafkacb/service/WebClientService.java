package com.kazzak.demokafkacb.service;

import com.kazzak.demokafkacb.GenericTransactionModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class WebClientService {


    private WebClient webClient;
    private final ReactiveCircuitBreaker reactiveCircuitBreaker;

    public WebClientService(ReactiveCircuitBreakerFactory reactiveCircuitBreakerFactory) {
        this.reactiveCircuitBreaker = reactiveCircuitBreakerFactory
                .create("customer-service");
        this.webClient = WebClient.builder()
                .baseUrl("http://localhost:8081")
                .build();
    }

    public Mono<String> send(String pix) {
        log.info("Enviando requisicao: {}", pix);
        return reactiveCircuitBreaker.run(webClient.put()
                        .uri("/api/v1/enviar")
                        .body(Mono.just(pix), GenericTransactionModel.class)
                        .header("dmip-token","123")
                        .accept(MediaType.valueOf("application/json"))
                        .retrieve()
                        .bodyToMono(String.class),
                throwable -> Mono.just("Servico indisponivel erro ao enviar a mensagem"));
    }
    public Mono<String> sendWithoutCB(String pix) {
        log.info("Enviando requisicao: {}", pix);
        return webClient.put()
                        .uri("/api/v1/enviar")
                        .body(Mono.just(pix), GenericTransactionModel.class)
                        .header("dmip-token","123")
                        .accept(MediaType.valueOf("application/json"))
                        .retrieve()
                        .bodyToMono(String.class);
    }


}
                                                                                                                                                                                                                                                                                                                                                                                                    