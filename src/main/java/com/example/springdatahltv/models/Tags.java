package com.example.springdatahltv.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

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
}
