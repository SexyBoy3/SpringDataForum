package com.example.springdatahltv.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Posts")
public class Posts extends BaseEntity{
    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private void setContent(String content) {
        this.content = content;
    }

    public Posts(String title, String content) {
        this.title = title;
        this.content = content;
    }
    protected Posts(){}

    @Override
    public String toString() {
        return "Posts{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", id=" + id +
                '}';
    }
    // Links below
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "posts")
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    private Set<PostsTags> postsTags = new HashSet<>();

    public Set<PostsTags> getPostsTags() {
        return postsTags;
    }

    public void setPostsTags(Set<PostsTags> postsTags) {
        this.postsTags = postsTags;
    }
}
