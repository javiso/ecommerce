package com.ecommerce.exception;

public class PriceNotFoundException extends RuntimeException {
    public PriceNotFoundException(final String message) {
        super(message);
    }
}