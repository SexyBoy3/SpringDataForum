package com.example.springdataforum.services;

import com.example.springdataforum.dtos.TagsDto;

import java.util.List;
import java.util.Optional;

public interface TagsService<Long> {
    TagsDto add(TagsDto tags);

    void delete(TagsDto tags);

    void deleteById(Long id);

    Optional<TagsDto> findTag(Long id);

    List<TagsDto> getAll();
}
