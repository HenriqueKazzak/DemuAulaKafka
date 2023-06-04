package com.kazzak.demokafkaproducer.exception;

public abstract class GenericUncheckedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    protected GenericUncheckedException() {
    }

    protected GenericUncheckedException(String message) {
        super(message);
    }

    protected GenericUncheckedException(String message, Throwable cause) {
        super(message, cause);
    }

    protected GenericUncheckedException(Throwable cause) {
        super(cause);
    }

    protected GenericUncheckedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}

