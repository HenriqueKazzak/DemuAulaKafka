package com.kazzak.demokafkaproducer.exception;

public abstract class GenericCheckedException extends Exception {

    private static final long serialVersionUID = 1L;

    protected GenericCheckedException() {
    }

    protected GenericCheckedException(String message) {
        super(message);
    }

    protected GenericCheckedException(String message, Throwable cause) {
        super(message, cause);
    }

    protected GenericCheckedException(Throwable cause) {
        super(cause);
    }

    protected GenericCheckedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
