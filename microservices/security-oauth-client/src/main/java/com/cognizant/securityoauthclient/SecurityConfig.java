package com.cognizant.securityoauthclient;

import org.springframework.context.annotation.*; import org.springframework.security.config.annotation.web.builders.HttpSecurity; import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig { @Bean SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { return http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated()).oauth2Login(oauth -> {}).build(); } }
