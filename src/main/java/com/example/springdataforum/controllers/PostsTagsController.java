package com.example.springdataforum.controllers;


import com.example.springdataforum.controllers.exceptions.UsersNotFoundException;

import com.example.springdataforum.dtos.PostsTagsDto;
import com.example.springdataforum.services.PostsTagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostsTagsController {
    @Autowired
    private PostsTagsService postsTagsService;

    @GetMapping("/poststags")
    Iterable<PostsTagsDto> all() {
        return postsTagsService.getAll();
    }

    @GetMapping("/poststags/{id}")
    PostsTagsDto one(@PathVariable Long id) throws Throwable {
        return (PostsTagsDto) postsTagsService.findPostsTags(id).orElseThrow(() -> new UsersNotFoundException(id));
    }

    @PostMapping("/poststags")
    PostsTagsDto newPostTag(@RequestBody PostsTagsDto newPostTag) {
        return postsTagsService.add(newPostTag);
    }

    @DeleteMapping("/poststags/{id}")
    void deleteUser(@PathVariable Long id) {
        postsTagsService.deleteById(id);
    }


}
