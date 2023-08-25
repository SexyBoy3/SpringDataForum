package com.example.springdataforum.services;

import com.example.springdataforum.dtos.UsersDto;

import java.util.List;
import java.util.Optional;

public interface UsersService<Long> {
    UsersDto add(UsersDto users);

    void delete(UsersDto users);

    void deleteById(Long id);

    Optional<UsersDto> findUser(Long id);

    List<UsersDto> getAll();

    List<UsersDto> findUsersByAge(String age);
}
