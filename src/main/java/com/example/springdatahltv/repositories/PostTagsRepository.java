package com.example.springdatahltv.repositories;

import com.example.springdatahltv.models.PostsTags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostTagsRepository extends JpaRepository<PostsTags,Long> {
}
