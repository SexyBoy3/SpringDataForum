package com.example.springdataforum.services.impl;

import com.example.springdataforum.dtos.PostsTagsDto;
import com.example.springdataforum.models.PostsTags;
import com.example.springdataforum.repositories.PostTagsRepository;
import com.example.springdataforum.services.PostsTagsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostsTagsServiceImpl implements PostsTagsService<Long> {
    @Autowired
    PostTagsRepository postTagsRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public PostsTagsDto add(PostsTagsDto postsTags) {
        PostsTags pt = modelMapper.map(postsTags, PostsTags.class);
        return modelMapper.map(postTagsRepository.save(pt), PostsTagsDto.class);

    }

    @Override
    public void delete(PostsTagsDto postsTags) {
        postTagsRepository.deleteById(postsTags.getId());
    }

    @Override
    public void deleteById(Long id) {
        postTagsRepository.deleteById(id);
    }

    @Override
    public Optional<PostsTagsDto> findPostsTags(Long id) {
        return Optional.ofNullable(modelMapper.map(postTagsRepository.findById(id), PostsTagsDto.class));
    }

    @Override
    public List<PostsTagsDto> getAll() {
        return postTagsRepository.findAll().stream().map((tm) ->
                modelMapper.map(tm, PostsTagsDto.class)).collect(Collectors.toList());

    }
}
