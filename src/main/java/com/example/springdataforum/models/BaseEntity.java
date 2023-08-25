package com.example.springdataforum.models;

import jakarta.persistence.*;

import java.io.Serializable;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected long id;

    protected void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
