package com.kazzak.demokafkacb;

import com.kazzak.demokafkacb.service.WebClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@SpringBootApplication
public class DemoCircutBreak {
    @Autowired
    private WebClientService webClientService;

    @PostMapping(
            value = "api/v1/enviar",
            consumes = "application/json"
    )
    public Mono<String> send(@RequestBody String payload) {
        return webClientService.send(payload);
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoCircutBreak.class, args);
    }

}
