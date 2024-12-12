package com.rigo.local.storage.localStorageProyect.api.errors;

public class InsufficientStockException extends RuntimeException {
    public InsufficientStockException(String message) {
        super(message);
    }
}
