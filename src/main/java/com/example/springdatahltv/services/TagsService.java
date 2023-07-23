package com.example.springdatahltv.services;

import com.example.springdatahltv.dtos.TagsDto;

import java.util.List;
import java.util.Optional;

public interface TagsService<Long> {
    TagsDto add(TagsDto tags);

    void delete(TagsDto tags);

    void deleteById(Long id);

    Optional<TagsDto> findTag(Long id);

    List<TagsDto> getAll();
}
