package com.example.springdataforum.controllers.advices;


import com.example.springdataforum.controllers.exceptions.PostsTagsNotFoundException;
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