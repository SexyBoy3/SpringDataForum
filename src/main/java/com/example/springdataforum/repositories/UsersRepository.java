package com.example.springdataforum.repositories;

import com.example.springdataforum.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    //Query below
    // Поиск по возрасту
    @Query(value = "SELECT u FROM Users AS u WHERE u.age = :age")
    List<Users> findAllByAge(@Param(value = "age") String age);

    @Query(value = "SELECT u FROM Users AS u " +
            "INNER JOIN Posts AS p ON u.id = p.users_id " +
            "INNER JOIN PostsTags as pt ON p.id = pt.posts_id " +
            "INNER JOIN Tags as t ON t.id = pt.tags_id " +
            "WHERE t.tagname = :tagname"
    )
    List<Users> findAllByTagname(@Param(value = "tagname") String tagname);

    List<Users> findUsersByEmail(String email);

    List<Users> findUsersByAge(String age);

    List<Users> findUsersByUsername(String username);

}
