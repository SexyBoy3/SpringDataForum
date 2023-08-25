package com.example.springdataforum.services;

import com.example.springdataforum.dtos.PostsTagsDto;

import java.util.List;
import java.util.Optional;

public interface PostsTagsService<Long> {
    PostsTagsDto add(PostsTagsDto postsTags);

    void delete(PostsTagsDto postsTags);

    void deleteById(Long id);

    Optional<PostsTagsDto> findPostsTags(Long id);

    List<PostsTagsDto> getAll();
}
