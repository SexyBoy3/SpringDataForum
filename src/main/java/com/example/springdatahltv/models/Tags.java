package com.example.springdatahltv.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Tags")
public class Tags extends BaseEntity{
    @Column(name = "tagname")
    private String tagname;

    public String getTagname() {
        return tagname;
    }

    private void setTagname(String tagname) {
        this.tagname = tagname;
    }
    public Set<PostsTags> getPostsTags() {
        return postsTags;
    }

    public void setPostsTags(Set<PostsTags> postsTags) {
        this.postsTags = postsTags;
    }
    public Tags(String tagname) {
        this.tagname = tagname;
    }
    protected Tags(){}

    @Override
    public String toString() {
        return "Tags{" +
                "tagname='" + tagname + '\'' +
                ", id=" + id +
                '}';
    }
    // Links below
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tags")
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    private Set<PostsTags> postsTags = new HashSet<>();


}
