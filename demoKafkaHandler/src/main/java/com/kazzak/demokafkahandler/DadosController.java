package com.kazzak.demokafkahandler;

import com.kazzak.demokafkahandler.model.ChavePix;
import com.kazzak.demokafkahandler.model.ContaBancaria;
import com.kazzak.demokafkahandler.persistence.ChavePixRepository;
import com.kazzak.demokafkahandler.persistence.ContaBancariaRepository;
import com.kazzak.demokafkahandler.persistence.entity.ChavePixEntity;
import com.kazzak.demokafkahandler.persistence.entity.ContaBancariaEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DadosController {
    @Autowired
    ChavePixRepository chavePixRepository;
    @Autowired
    private ContaBancariaRepository contaBancariaRepository;

    @PostMapping(
            value = "api/v1/transacao_chave_pix",
            consumes = "application/json"
    )
    public ResponseEntity criarChavePix(@RequestBody ChavePix payload) {
        ChavePixEntity chavePixEntity = new ChavePixEntity();
        BeanUtils.copyProperties(payload, chavePixEntity);
        chavePixRepository.save(chavePixEntity);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @PostMapping(
            value = "api/v1/transacao_conta_bancaria",
            consumes = "application/json"
    )
    public ResponseEntity criarContaBancaria(@RequestBody ContaBancaria payload) {
        ContaBancariaEntity contaBancariaEntity = new ContaBancariaEntity();
        BeanUtils.copyProperties(payload, contaBancariaEntity);
        contaBancariaRepository.save(contaBancariaEntity);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
