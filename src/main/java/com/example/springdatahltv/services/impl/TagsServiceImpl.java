package com.example.springdatahltv.services.impl;

import com.example.springdatahltv.dtos.TagsDto;
import com.example.springdatahltv.models.Tags;
import com.example.springdatahltv.repositories.PostsRepository;
import com.example.springdatahltv.repositories.TagsRepository;
import com.example.springdatahltv.services.TagsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TagsServiceImpl implements TagsService<Long> {

    @Autowired
    TagsRepository tagsRepository;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public TagsDto add(TagsDto tags) {
        Tags t = modelMapper.map(tags, Tags.class);
        return modelMapper.map(tagsRepository.save(t), TagsDto.class);

    }

    @Override
    public void delete(TagsDto tags) {
        tagsRepository.deleteById(tags.getId());

    }

    @Override
    public void deleteById(Long id) {
        tagsRepository.deleteById(id);

    }

    @Override
    public Optional<TagsDto> findTag(Long id) {
        return Optional.ofNullable(modelMapper.map(tagsRepository.findById(id), TagsDto.class));

    }

    @Override
    public List<TagsDto> getAll() {
        return tagsRepository.findAll().stream().map((t) ->
                modelMapper.map(t, TagsDto.class)).collect(Collectors.toList());

    }
}
