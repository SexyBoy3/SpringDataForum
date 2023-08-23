package com.example.springdataforum.controllers;


import com.example.springdataforum.controllers.exceptions.UsersNotFoundException;
import com.example.springdataforum.dtos.PostsDto;

import com.example.springdataforum.services.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostsController {
    @Autowired
    private PostsService postsService;

    @GetMapping("/posts")
    Iterable<PostsDto> all() {return postsService.getAll();}
    @GetMapping("/posts/{id}")
    PostsDto one(@PathVariable Long id) throws Throwable {
        return (PostsDto) postsService.findPost(id).orElseThrow(() -> new UsersNotFoundException(id));
    }

    @PostMapping("/posts")
    PostsDto newPost(@RequestBody PostsDto newPost) {return postsService.add(newPost);}

    @DeleteMapping("/posts/{id}")
    void deletePost(@PathVariable Long id) {
        postsService.deleteById(id);}

    @RequestMapping(value = "/posts/query1", method = RequestMethod.GET)
    List<PostsDto> findPostsByTagname (
            @RequestParam(name = "tagname") String tagname) throws Throwable {
        return postsService.findPostsByTagname(tagname);
    }


}
