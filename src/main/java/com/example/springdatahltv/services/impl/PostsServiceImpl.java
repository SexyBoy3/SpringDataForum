package com.example.springdatahltv.services.impl;

import com.example.springdatahltv.dtos.PostsDto;
import com.example.springdatahltv.models.Posts;
import com.example.springdatahltv.repositories.PostsRepository;
import com.example.springdatahltv.services.PostsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostsServiceImpl implements PostsService<Long> {

    @Autowired
    PostsRepository postsRepository;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public PostsDto add(PostsDto posts) {
        Posts p = modelMapper.map(posts, Posts.class);
        return modelMapper.map(postsRepository.save(p), PostsDto.class);

    }

    @Override
    public void delete(PostsDto posts) {
            postsRepository.deleteById(posts.getId());
    }

    @Override
    public void deleteById(Long id) {
        postsRepository.deleteById(id);

    }

    @Override
    public Optional<PostsDto> findMatch(Long id) {
        return Optional.ofNullable(modelMapper.map(postsRepository.findById(id), PostsDto.class));
    }

    @Override
    public List<PostsDto> getAll() {
        return postsRepository.findAll().stream().map((u) ->
                modelMapper.map(u, PostsDto.class)).collect(Collectors.toList());

    }

    @Override
    public List<PostsDto> findPostsByTagname(String tagname) {
        return postsRepository.findAllByTagname(tagname).stream().map((p) ->
                modelMapper.map(p, PostsDto.class)).collect(Collectors.toList());
    }
}
