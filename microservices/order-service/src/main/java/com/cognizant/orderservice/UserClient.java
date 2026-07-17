package com.cognizant.orderservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="user-service", url="${user.service.url:http://localhost:8086}")
public interface UserClient { @GetMapping("/users/{id}") UserDto getUser(@PathVariable Long id); record UserDto(Long id, String name, String email) {} }
