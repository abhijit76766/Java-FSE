package com.example.springtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Exercise 4: Integration Test with Spring Boot
 * Full flow: controller -> service -> repository -> (in-memory H2) database.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreateAndFetchUser_endToEnd() throws Exception {
        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":10,\"name\":\"Rahul\"}"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/users/10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Rahul"));

        // verify it actually landed in the database, not just mocked
        User saved = userRepository.findById(10L).orElse(null);
        org.junit.jupiter.api.Assertions.assertNotNull(saved);
        org.junit.jupiter.api.Assertions.assertEquals("Rahul", saved.getName());
    }
}
