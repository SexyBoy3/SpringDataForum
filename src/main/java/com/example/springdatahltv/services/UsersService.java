package com.example.springdatahltv.services;

import com.example.springdatahltv.dtos.UsersDto;

import java.util.List;
import java.util.Optional;

public interface UsersService<Long> {
    UsersDto add(UsersDto users);

    void delete(UsersDto users);

    void deleteById(Long id);

    Optional<UsersDto> findMatch(Long id);

    List<UsersDto> getAll();
    List<UsersDto> findUsersByAge(String age);
}
