package com.kazzak.demokafkahandler.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Setter
public class ContaBancariaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private Integer contaOrigem;
    private Integer contaDestino;
    private Integer agenciaOrigem;
    private Integer agenciaDestino;
    private Integer bancoOrigem;
    private Integer bancoDestino;
    private String portaOrigem;

    @CreationTimestamp
    private Instant dataHora;

}
