package com.example.springdataforum.controllers;


import com.example.springdataforum.controllers.exceptions.UsersNotFoundException;

import com.example.springdataforum.dtos.TagsDto;
import com.example.springdataforum.services.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TagsController {
    @Autowired
    private TagsService tagsService;

    @GetMapping("/tags")
    Iterable<TagsDto> all() {
        return tagsService.getAll();
    }

    @GetMapping("/tags/{id}")
    TagsDto one(@PathVariable Long id) throws Throwable {
        return (TagsDto) tagsService.findTag(id).orElseThrow(() -> new UsersNotFoundException(id));
    }

    @PostMapping("/tags")
    TagsDto newUser(@RequestBody TagsDto newTag) {
        return tagsService.add(newTag);
    }

    @DeleteMapping("/tags/{id}")
    void deleteUser(@PathVariable Long id) {
        tagsService.deleteById(id);
    }


}
