package com.example.springtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Exercise 3: Testing a REST Controller with MockMvc
 * Exercise 5: Test Controller POST Endpoint
 * Exercise 8: Test Controller Exception Handling
 */
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testGetUser_returnsUser() throws Exception {
        User user = new User(1L, "Abhijit");
        when(userService.getUserById(1L)).thenReturn(user);

        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Abhijit"));
    }

    @Test
    public void testCreateUser_returnsCreatedUser() throws Exception {
        User user = new User(2L, "Priya");
        when(userService.saveUser(org.mockito.ArgumentMatchers.any(User.class))).thenReturn(user);

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":2,\"name\":\"Priya\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Priya"));
    }

    @Test
    public void testGetUserOrThrow_notFound_returns404() throws Exception {
        when(userService.getUserByIdOrThrow(99L))
                .thenThrow(new java.util.NoSuchElementException("User not found: 99"));

        mockMvc.perform(get("/users/lookup/99"))
                .andExpect(status().isNotFound());
    }
}
