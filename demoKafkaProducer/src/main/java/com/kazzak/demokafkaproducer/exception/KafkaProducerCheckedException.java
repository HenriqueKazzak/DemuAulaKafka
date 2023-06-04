package com.kazzak.demokafkaproducer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class KafkaProducerCheckedException extends GenericCheckedException {

    private final String topic;

    private final String message;

    public KafkaProducerCheckedException(String message, String topic) {
        super(message);
        this.topic = topic;
        this.message = message;
    }

    public KafkaProducerCheckedException(String message, String topic, Throwable cause) {
        super(message,cause);
        this.topic = topic;
        this.message = message;
    }

    public String getTopic() {
        return topic;
    }

    public String getMesssage(){
        return this.message;
    }
}
