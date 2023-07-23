package com.example.springdatahltv.controllers.exceptions;

public class PostsTagsNotFoundException extends RuntimeException {
    public PostsTagsNotFoundException(Long id) {
        super("Could not find user " + id);
    }
}