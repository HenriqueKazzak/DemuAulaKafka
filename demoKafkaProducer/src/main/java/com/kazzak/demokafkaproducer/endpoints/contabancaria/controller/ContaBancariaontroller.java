package com.kazzak.demokafkaproducer.endpoints.contabancaria.controller;

import com.kazzak.demokafkaproducer.exception.KafkaProducerCheckedException;
import com.kazzak.demokafkaproducer.model.ContaBancaria;
import com.kazzak.demokafkaproducer.response.response.ApiResponse;
import com.kazzak.demokafkaproducer.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContaBancariaontroller {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping(
            value = "api/v1/transacao_conta_bancaria",
            consumes = "application/json"
    )
    public ResponseEntity<ApiResponse<ContaBancaria>> criarCpfCnpjNegativo(@RequestBody ContaBancaria payload) throws KafkaProducerCheckedException, KafkaProducerCheckedException {
        return kafkaProducerService.produce(payload);
    }

}
