package com.example.springdatahltv.repositories;

import com.example.springdatahltv.models.PostsTags;
import com.example.springdatahltv.models.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsRepository extends JpaRepository<Tags,Long> {
}
