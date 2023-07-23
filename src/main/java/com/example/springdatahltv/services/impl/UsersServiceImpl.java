package com.example.springdatahltv.services.impl;

import com.example.springdatahltv.dtos.UsersDto;
import com.example.springdatahltv.repositories.UsersRepository;
import com.example.springdatahltv.services.UsersService;
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
        return null;
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
}
