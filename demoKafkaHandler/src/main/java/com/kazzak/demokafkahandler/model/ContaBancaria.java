package com.kazzak.demokafkahandler.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContaBancaria {
    @JsonProperty("agenciaOrigem")
    private Integer agenciaOrigem;

    @JsonProperty("numeroContaOrigem")
    private Integer contaOrigem;

    @JsonProperty("bancoOrigem")
    private Integer bancoOrigem;

    @JsonProperty("agenciaDestino")
    private Integer agenciaDestino;

    @JsonProperty("numeroContaDestino")
    private Integer contaDestino;

    @JsonProperty("bancoDestino")
    private Integer bancoDestino;

}
