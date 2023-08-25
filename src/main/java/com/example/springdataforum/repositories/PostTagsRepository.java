package com.example.springdataforum.repositories;

import com.example.springdataforum.models.PostsTags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostTagsRepository extends JpaRepository<PostsTags, Long> {
}
