package com.example.springdataforum.services.impl;


import com.example.springdataforum.dtos.PostsDto;
import com.example.springdataforum.dtos.UsersDto;
import com.example.springdataforum.models.Users;
import com.example.springdataforum.repositories.UsersRepository;
import com.example.springdataforum.services.UsersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService<Long> {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public UsersDto add(UsersDto users) {
        Users u = modelMapper.map(users, Users.class);
        return modelMapper.map(usersRepository.save(u), UsersDto.class);
    }

    @Override
    public void delete(UsersDto users) {
        usersRepository.deleteById(users.getId());
    }

    @Override
    public void deleteById(Long id) {
        usersRepository.deleteById(id);

    }

    @Override
    public Optional<UsersDto> findUser(Long id) {
        return Optional.ofNullable(modelMapper.map(usersRepository.findById(id), UsersDto.class));
    }

    @Override
    public List<UsersDto> getAll() {
        return
                usersRepository.findAll().stream().map((u) ->
                        modelMapper.map(u, UsersDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<UsersDto> findUsersByAge(String age) {
        return usersRepository.findAllByAge(age).stream().map((u) ->
                modelMapper.map(u, UsersDto.class)).collect(Collectors.toList());

    }

    @Override
    public List<UsersDto> findUsersByTagname(String tagname) {
        return usersRepository.findAllByTagname(tagname).stream().map((u) ->
                modelMapper.map(u, UsersDto.class)).collect(Collectors.toList());
    }
}
