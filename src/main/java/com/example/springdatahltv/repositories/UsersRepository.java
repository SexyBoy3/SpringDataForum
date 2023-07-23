package com.example.springdatahltv.repositories;

import com.example.springdatahltv.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {
    //Query below
    // Поиск по возрасту
    @Query(value = "SELECT u FROM Users AS u WHERE u.age = :age")
    List<Users> findAllByAge(@Param(value = "age") String age);
    List<Users> findUsersByEmail (String email);
    List<Users> findUsersByAge (String age);
    List<Users> findUsersByUsername (String username);

}
