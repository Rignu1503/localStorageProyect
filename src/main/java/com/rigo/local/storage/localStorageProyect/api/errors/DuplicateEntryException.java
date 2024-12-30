package com.rigo.local.storage.localStorageProyect.api.errors;


public class DuplicateEntryException extends RuntimeException {

    public DuplicateEntryException(String message ) {
        super(message + " already exists");
    }
}