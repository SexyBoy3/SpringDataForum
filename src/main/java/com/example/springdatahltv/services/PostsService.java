package com.example.springdatahltv.services;

import com.example.springdatahltv.dtos.PostsDto;

import java.util.List;
import java.util.Optional;

public interface PostsService {
    PostsDto add(PostsDto posts);

    void delete(PostsDto posts);

    void deleteById(Long id);

    Optional<PostsDto> findMatch(Long id);

    List<PostsDto> getAll();
    List<PostsDto> findPostsByTagname(String tagname);
}
