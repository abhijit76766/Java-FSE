package com.cognizant.userservice;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController { private final UserRepository repository; public UserController(UserRepository repository){this.repository=repository;} @GetMapping public List<User> all(){return repository.findAll();} @GetMapping("/{id}") public User one(@PathVariable Long id){return repository.findById(id).orElseThrow();} @PostMapping public User create(@RequestBody User user){return repository.save(user);} }
