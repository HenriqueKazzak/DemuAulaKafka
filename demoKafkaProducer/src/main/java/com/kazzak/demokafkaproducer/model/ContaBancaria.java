package com.kazzak.demokafkaproducer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContaBancaria {
    @JsonProperty("agenciaOrigem")
    private Integer agencia;

    @JsonProperty("numeroContaOrigem")
    private Integer numeroConta;

    @JsonProperty("bancoOrigem")
    private Integer banco;

    @JsonProperty("agenciaDestino")
    private Integer agenciaDestino;

    @JsonProperty("numeroContaDestino")
    private Integer numeroContaDestino;

    @JsonProperty("bancoDestino")
    private Integer bancoDestino;

}
