package com.example.springdatahltv.repositories;

import com.example.springdatahltv.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {
    //Query below
    List<Users> findUsersByEmail (String email);
    List<Users> findUsersByAge (String age);
    List<Users> findUsersByUsername (String username);

}
