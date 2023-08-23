package com.example.springdataforum.services;

import com.example.springdataforum.dtos.PostsDto;

import java.util.List;
import java.util.Optional;

public interface PostsService<Long> {
    PostsDto add(PostsDto posts);

    void delete(PostsDto posts);

    void deleteById(Long id);

    Optional<PostsDto> findPost(Long id);

    List<PostsDto> getAll();
    List<PostsDto> findPostsByTagname(String tagname);
}
