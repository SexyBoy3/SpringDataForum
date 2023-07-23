package com.example.springdatahltv.controllers.advices;


import com.example.springdatahltv.controllers.exceptions.PostsTagsNotFoundException;
import com.example.springdatahltv.controllers.exceptions.UsersNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PostsTagsNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(PostsTagsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String matchNotFoundHandler(PostsTagsNotFoundException ex) {
        return ex.getMessage();
    }
}