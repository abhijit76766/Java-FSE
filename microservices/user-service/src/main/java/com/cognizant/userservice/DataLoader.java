package com.cognizant.userservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner { private final UserRepository repository; public DataLoader(UserRepository repository){this.repository=repository;} public void run(String... args) { User user = new User(); user.setName("Asha Rao"); user.setEmail("asha@example.com"); repository.save(user); } }
