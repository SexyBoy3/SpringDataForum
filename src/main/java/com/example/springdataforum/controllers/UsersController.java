package com.example.springdataforum.controllers;


import com.example.springdataforum.controllers.exceptions.UsersNotFoundException;

import com.example.springdataforum.dtos.UsersDto;
import com.example.springdataforum.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    Iterable<UsersDto> all() {
        return usersService.getAll();
    }

    @GetMapping("/users/{id}")
    UsersDto one(@PathVariable Long id) throws Throwable {
        return (UsersDto) usersService.findUser(id).orElseThrow(() -> new UsersNotFoundException(id));
    }

    @PostMapping("/users")
    UsersDto newUser(@RequestBody UsersDto newUser) {
        return usersService.add(newUser);
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {
        usersService.deleteById(id);
    }

    @RequestMapping(value = "/users/query1", method = RequestMethod.GET)
    List<UsersDto> findUsersByAge(
            @RequestParam(name = "age") String age) throws Throwable {
        return usersService.findUsersByAge(age);
    }


}
