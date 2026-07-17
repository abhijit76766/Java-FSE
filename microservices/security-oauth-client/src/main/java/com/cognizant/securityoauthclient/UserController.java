package com.cognizant.securityoauthclient;

import java.security.Principal; import org.springframework.web.bind.annotation.*;

@RestController
public class UserController { @GetMapping("/user") public Principal user(Principal principal) { return principal; } }
