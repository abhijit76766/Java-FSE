package com.cognizant.securityjwtservice;

import java.security.Principal; import java.util.Map; import org.springframework.web.bind.annotation.*;

@RestController
public class JwtController { private final JwtTokenProvider provider; public JwtController(JwtTokenProvider provider){this.provider=provider;} @PostMapping("/auth/token") public Map<String,String> token(@RequestParam String username){ return Map.of("token", provider.createToken(username)); } @GetMapping("/secure") public Map<String,String> secure(Principal principal){ return Map.of("message", "JWT secured endpoint", "user", principal.getName()); } }
