package com.rbc.assessment.dowjones.exception;

public class StockNotFoundException extends RuntimeException {

    public StockNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StockNotFoundException(String message) {
        super(message);
    }
}
