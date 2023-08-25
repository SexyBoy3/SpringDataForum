package com.example.springdataforum.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PostsDto {
    private long id;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    private String title;
    private String content;
    private long users_id;
    @JsonIgnore
    private UsersDto usersDto;

    public long getUsers_id() {
        return users_id;
    }

    public void setUsers_id(long users_id) {
        this.users_id = users_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UsersDto getUsersDto() {
        return usersDto;
    }

    public void setUsersDto(UsersDto usersDto) {
        this.usersDto = usersDto;
    }

    public PostsDto(long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public PostsDto() {
    }

    @Override
    public String toString() {
        return "PostsDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }


}
