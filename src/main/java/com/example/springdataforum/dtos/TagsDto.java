package com.example.springdataforum.dtos;

import com.example.springdataforum.models.PostsTags;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

public class TagsDto {
    private long id;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @JsonIgnore
    public Set<PostsTags> postsTags = new HashSet<>();


    private String tagname;

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    public TagsDto(long id, String tagname) {
        this.id = id;
        this.tagname = tagname;
    }

    public TagsDto() {
    }

    public Set<PostsTags> getPostsTags() {
        return postsTags;
    }

    public void setPostsTags(Set<PostsTags> postsTags) {
        this.postsTags = postsTags;
    }
}
