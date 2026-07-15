package com.example.springtest;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    // Exercise 7: Custom repository query
    List<User> findByName(String name);
}
