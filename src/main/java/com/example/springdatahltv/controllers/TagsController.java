package com.example.springdatahltv.controllers;


import com.example.springdatahltv.controllers.exceptions.UsersNotFoundException;

import com.example.springdatahltv.dtos.TagsDto;
import com.example.springdatahltv.services.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TagsController {
    @Autowired
    private TagsService tagsService;

    @GetMapping("/tags")
    Iterable<TagsDto> all() {return tagsService.getAll();}
    @GetMapping("/tags/{id}")
    TagsDto one(@PathVariable Long id) throws Throwable {
        return (TagsDto) tagsService.findTag(id).orElseThrow(() -> new UsersNotFoundException(id));
    }

    @PostMapping("/tags")
    TagsDto newUser(@RequestBody TagsDto newTag) {return tagsService.add(newTag);}

    @DeleteMapping("/tags/{id}")
    void deleteUser(@PathVariable Long id) {
        tagsService.deleteById(id);}




}
