package com.example.springdataforum.repositories;

import com.example.springdataforum.models.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query(value = "SELECT p FROM Posts AS p " +
            "INNER JOIN PostsTags as pt ON p.id = pt.posts_id " +
            "INNER JOIN Tags as t ON t.id = pt.tags_id " +
            "WHERE t.tagname = :tagname")
    List<Posts> findAllByTagname(@Param(value = "tagname") String tagname);

    List<Posts> findPostsByTitle(String title);

}
