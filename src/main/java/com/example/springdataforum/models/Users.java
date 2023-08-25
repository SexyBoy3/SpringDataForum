package com.example.springdataforum.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class Users extends BaseEntity {
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "status")
    private String status;
    @Column(name = "avatar_url")
    private String avatar_url;
    @Column(name = "age")
    private String age;

    public String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    private void setStatus(String status) {
        this.status = status;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    private void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getAge() {
        return age;
    }

    private void setAge(String age) {
        this.age = age;
    }

    public Set<Posts> getPosts() {
        return posts;
    }

    public void setPosts(Set<Posts> posts) {
        this.posts = posts;
    }

    public Users(String username, String email, String password, String status, String avatar_url, String age) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.status = status;
        this.avatar_url = avatar_url;
        this.age = age;
    }

    protected Users() {
    }

    @Override
    public String toString() {
        return "Users{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                ", age='" + age + '\'' +
                ", id=" + id +
                '}';
    }
    // Links below

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "users") // Lazy не заводится, узнать почему
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    @JsonIgnore
    private Set<Posts> posts;
}
