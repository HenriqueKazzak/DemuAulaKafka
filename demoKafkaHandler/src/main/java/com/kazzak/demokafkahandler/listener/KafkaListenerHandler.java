package com.kazzak.demokafkahandler.listener;

import com.kazzak.demokafkahandler.model.ChavePix;
import com.kazzak.demokafkahandler.model.ContaBancaria;
import com.kazzak.demokafkahandler.persistence.ChavePixRepository;
import com.kazzak.demokafkahandler.persistence.ContaBancariaRepository;
import com.kazzak.demokafkahandler.persistence.entity.ChavePixEntity;
import com.kazzak.demokafkahandler.persistence.entity.ContaBancariaEntity;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@KafkaListener(topics = "demo-aula")
public class KafkaListenerHandler {

    @Autowired
    ChavePixRepository chavePixRepository;

    @Autowired
    ContaBancariaRepository contaBancariaRepository;

    @Value("${server.port}")
    String portaOrigem;
    @KafkaHandler
    public void listenerListaNegativa(@Payload @Valid ChavePix message) {
        log.info("Mensagem recebida: {}", message);
        ChavePixEntity chavePixEntity = new ChavePixEntity();
        chavePixEntity.setPortaOrigem(portaOrigem);
        BeanUtils.copyProperties(message, chavePixEntity);
        log.info("Salvando chavePixEntity: {}", chavePixEntity);
        chavePixRepository.save(chavePixEntity);
    }
    @KafkaHandler
    public void listenerListaNegativa(@Payload @Valid ContaBancaria message) {
        log.info("Mensagem recebida: {}", message);
        ContaBancariaEntity contaBancariaEntity = new ContaBancariaEntity();
        BeanUtils.copyProperties(message, contaBancariaEntity);
        contaBancariaEntity.setPortaOrigem(portaOrigem);
        log.info("Salvando contaBancariaEntity: {}", contaBancariaEntity);
        contaBancariaRepository.save(contaBancariaEntity);
    }

    @KafkaHandler(isDefault = true)
    public void defaulthander (@Payload String m){
        log.warn("Mensagem não tratada: {}", m);
    }

}
