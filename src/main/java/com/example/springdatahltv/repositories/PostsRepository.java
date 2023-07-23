package com.example.springdatahltv.repositories;

import com.example.springdatahltv.models.Posts;
import com.example.springdatahltv.models.PostsTags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<Posts,Long> {
    List<Posts> findPostsByTitle(String title);
}
