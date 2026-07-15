package com.example.springtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Exercise 7: Test Custom Repository Query
 */
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByName_returnsMatchingUsers() {
        userRepository.save(new User(1L, "Abhijit"));
        userRepository.save(new User(2L, "Abhijit"));
        userRepository.save(new User(3L, "Priya"));

        List<User> results = userRepository.findByName("Abhijit");

        assertEquals(2, results.size());
    }
}
