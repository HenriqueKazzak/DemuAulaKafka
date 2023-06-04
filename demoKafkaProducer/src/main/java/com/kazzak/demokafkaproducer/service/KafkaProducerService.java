package com.kazzak.demokafkaproducer.service;


import com.kazzak.demokafkaproducer.exception.KafkaProducerCheckedException;
import com.kazzak.demokafkaproducer.exception.response.ErrorResponse;
import com.kazzak.demokafkaproducer.response.response.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    private String topic = "teste";
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerService.class);

    public <T> ResponseEntity<ApiResponse<T>> produce(T message) throws KafkaProducerCheckedException {
        ApiResponse<T> apiResponse = new ApiResponse.ApiResponseBuilder<T>()
                .topico(topic)
                .payload(message)

                .build();
        try {
            kafkaTemplate.setMessageConverter(new JsonMessageConverter());

            CompletableFuture<SendResult<String, T>> resultListenableFuture = kafkaTemplate.send(topic,message);
            kafkaTemplate.flush();
            resultListenableFuture.whenComplete((result,erro) -> {
                if (erro == null) {
                    LOGGER.debug("Menssagem enviada ao Topico Kafka: {} - Mensagem: {}",result.getRecordMetadata().topic(),result.getProducerRecord().value());
                    apiResponse.setHttpStatus(HttpStatus.OK);
                    apiResponse.setMensagem("Mensagem enviada no Topico Kafka com sucesso!");
                }
                else{
                    LOGGER.error("Erro ao postar mensagem no Kafka: {}", erro.getMessage());
                    apiResponse.setHttpStatus(HttpStatus.SERVICE_UNAVAILABLE);
                    apiResponse.setMensagem("Erro ao enviar mensagem no Topico Kafka!");
                }
            });
        }
        catch (Exception erro) {
            LOGGER.error("Erro ao Tentar Conexao com o Topico: {} - Error: {}", topic, erro.getMessage());
            ErrorResponse errorResponse = new ErrorResponse(
                    String.format("Erro ao Tentar Conexao com o Topico %s", topic), erro.getMessage());
            throw new KafkaProducerCheckedException(errorResponse.getMensagem(), topic);
        }

        return new ResponseEntity<ApiResponse<T>>(apiResponse,apiResponse.getHttpStatus());
    }

}
