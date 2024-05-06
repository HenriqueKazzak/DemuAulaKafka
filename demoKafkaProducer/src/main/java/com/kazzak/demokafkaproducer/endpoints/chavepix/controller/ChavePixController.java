package com.kazzak.demokafkaproducer.endpoints.chavepix.controller;

import com.kazzak.demokafkaproducer.exception.KafkaProducerCheckedException;
import com.kazzak.demokafkaproducer.model.ChavePix;
import com.kazzak.demokafkaproducer.response.response.ApiResponse;
import com.kazzak.demokafkaproducer.service.KafkaProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ChavePixController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping(
            value = "api/v1/transacao_chave_pix",
            consumes = "application/json"
    )
    public ResponseEntity<ApiResponse<ChavePix>> criarChavePixNegativa(@RequestBody ChavePix payload) throws KafkaProducerCheckedException {
        log.info("Recebi do outro servico: {}", payload);
        return kafkaProducerService.produce(payload);
    }
}
