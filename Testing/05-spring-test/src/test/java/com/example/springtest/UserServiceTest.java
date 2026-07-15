package com.example.springtest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * Exercise 2: Mocking a Repository in a Service Test
 * Exercise 6: Test Service Exception Handling
 */
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetUserById_found() {
        User user = new User(1L, "Abhijit");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User result = userService.getUserById(1L);

        assertNotNull(result);
        assertEquals("Abhijit", result.getName());
    }

    @Test
    public void testGetUserById_notFound_returnsNull() {
        when(userRepository.findById(99L)).thenReturn(Optional.empty());

        User result = userService.getUserById(99L);

        assertNull(result);
    }

    @Test
    public void testGetUserByIdOrThrow_notFound_throwsException() {
        when(userRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class,
                () -> userService.getUserByIdOrThrow(99L));
    }
}
