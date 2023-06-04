package com.kazzak.demokafkaproducer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonPropertyOrder(alphabetic = true)
public class ChavePix {

    @JsonProperty("chaveOrigem")
    private String chaveDestino;

    @JsonProperty("chaveDestino")
    private String chaveOrigem;

}
