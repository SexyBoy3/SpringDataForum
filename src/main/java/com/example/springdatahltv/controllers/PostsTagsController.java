package com.example.springdatahltv.controllers;


import com.example.springdatahltv.controllers.exceptions.UsersNotFoundException;

import com.example.springdatahltv.dtos.PostsTagsDto;
import com.example.springdatahltv.services.PostsTagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostsTagsController {
    @Autowired
    private PostsTagsService postsTagsService;

    @GetMapping("/users")
    Iterable<PostsTagsDto> all() {return postsTagsService.getAll();}
    @GetMapping("/users/{id}")
    PostsTagsDto one(@PathVariable Long id) throws Throwable {
        return (PostsTagsDto) postsTagsService.findPostsTags(id).orElseThrow(() -> new UsersNotFoundException(id));
    }

    @PostMapping("/users")
    PostsTagsDto newPostTag(@RequestBody PostsTagsDto newPostTag) {return postsTagsService.add(newPostTag);}

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {
        postsTagsService.deleteById(id);}




}
