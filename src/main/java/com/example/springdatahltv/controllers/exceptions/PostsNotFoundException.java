package com.example.springdatahltv.controllers.exceptions;

public class PostsNotFoundException extends RuntimeException {
    public PostsNotFoundException(Long id) {
        super("Could not find post " + id);
    }
}