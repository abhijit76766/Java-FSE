package com.example.springtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Exercise 6: used to demonstrate exception handling
    public User getUserByIdOrThrow(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found: " + id));
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
