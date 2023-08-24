package com.example.springdataforum.init;


import com.example.springdataforum.dtos.PostsDto;
import com.example.springdataforum.dtos.PostsTagsDto;
import com.example.springdataforum.dtos.TagsDto;
import com.example.springdataforum.dtos.UsersDto;
import com.example.springdataforum.services.PostsService;
import com.example.springdataforum.services.PostsTagsService;
import com.example.springdataforum.services.TagsService;
import com.example.springdataforum.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {


    @Autowired
    PostsService postsService;
    @Autowired
    PostsTagsService postsTagsService;
    @Autowired
    TagsService tagsService;
    @Autowired
    UsersService usersService;


    private void seedData() throws IOException {

        UsersDto users1 = new UsersDto(1,"Panda","1234","Clever","ya.ru","21");
        UsersDto users2 = new UsersDto(2,"KittyCat124","1234","Meow","ya.ru","21");
        usersService.add(users1); usersService.add(users2);

        TagsDto tags1 = new TagsDto(1,"Super");
        TagsDto tags2 = new TagsDto(2,"SuperPuper");
        tagsService.add(tags1); tagsService.add(tags2);

        PostsDto posts1 = new PostsDto(1,"Title","IvanZolo2004");
        PostsDto posts2 = new PostsDto(2,"Kotlin","Based");
        posts1.setUsers_id(1);
        posts2.setUsers_id(2);
        postsService.add(posts1); postsService.add(posts2);

        PostsTagsDto postsTags1 = new PostsTagsDto(posts1.getId(), tags1.getId());
        PostsTagsDto postsTags2 = new PostsTagsDto(posts2.getId(), tags2.getId());
        postsTagsService.add(postsTags1); postsTagsService.add(postsTags2);







    }
    private void printPostsByTagname(String tagname){
        postsService.findPostsByTagname(tagname).forEach(System.out::println);
    }
    private void printUsersByAge(String age){
        usersService.findUsersByAge(age).forEach(System.out::println);
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
        printPostsByTagname("Super");
        printUsersByAge("21");

        System.out.println("End");

    }
}
