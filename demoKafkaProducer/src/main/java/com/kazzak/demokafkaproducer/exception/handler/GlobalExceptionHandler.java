package com.kazzak.demokafkaproducer.exception.handler;

import com.kazzak.demokafkaproducer.exception.KafkaProducerCheckedException;
import com.kazzak.demokafkaproducer.exception.response.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(KafkaProducerCheckedException.class)
    public ResponseEntity<ErrorResponse> handleKafkaProducerCheckedException(KafkaProducerCheckedException ex) {
        String errorMessage = String.format("Erro ao inserir no topico %s", ex.getTopic());
        ErrorResponse errorResponse = new ErrorResponse(errorMessage, ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        logger.error("Excecao sendo capturada, Codifo de Erro: {}, Mensagem: {}, Excecao: {}, Causa: {}", errorResponse.getHttpStatus(), errorResponse.getMensagem(), errorResponse.getDetalhe(), ex, ex.getCause());
        return ResponseEntity.status(errorResponse.getHttpStatus()).body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        List<String> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());
        String errorMessage = "Solicitação com parametros incorretos";
        logger.error(String.format("%s: %s",errorMessage, errors.toString()));
        ErrorResponse errorResponse = new ErrorResponse(errorMessage,errors.toString(),HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(errorResponse.getHttpStatus()).body(errorResponse);
    }
}
