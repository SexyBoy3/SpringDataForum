package com.example.springdatahltv.controllers.exceptions;

public class TagsNotFoundException extends RuntimeException {
    public TagsNotFoundException(Long id) {
        super("Could not find tag " + id);
    }
}