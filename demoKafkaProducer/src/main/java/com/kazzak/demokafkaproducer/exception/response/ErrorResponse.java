package com.kazzak.demokafkaproducer.exception.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@JsonIgnoreProperties("httpStatus")
public class ErrorResponse {

    private String mensagem;
    private String detalhe;
    private HttpStatus httpStatus;

    public ErrorResponse(String mensagem, String details, HttpStatus httpStatus) {
        this.mensagem = mensagem;
        this.detalhe = details;
        this.httpStatus = httpStatus;
    }
    public ErrorResponse(String mensagem, String details) {
        this.mensagem = mensagem;
        this.detalhe = details;
    }
}
