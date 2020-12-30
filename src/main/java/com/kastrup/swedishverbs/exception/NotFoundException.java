package com.kastrup.swedishverbs.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(long id) {
        super("Verb with ID: " + id + " not found.");
    }
}
