package com.example.mockspring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Exercise 3: Mocking a Service Dependency in an Integration Test
 *
 * @SpringBootTest boots the full application context, but @MockBean
 * still replaces UserService with a Mockito mock - useful when you
 * want the real web layer (filters, exception handlers, etc.) but a
 * controlled/stubbed service layer.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testGetUser_withMockedServiceInFullContext() throws Exception {
        User mockUser = new User(5L, "Rahul");
        when(userService.getUserById(5L)).thenReturn(mockUser);

        mockMvc.perform(get("/users/5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Rahul"));
    }
}
