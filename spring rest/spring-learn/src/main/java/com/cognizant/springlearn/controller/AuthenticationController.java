package com.cognizant.springlearn.controller;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * doc 5: "Create authentication controller and configure it in SecurityConfig",
 * "Read Authorization header and decode the username and password",
 * "Generate token based on the user".
 */
@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    // Hands-on hardcodes this literal for simplicity, matching the JWT
    // filter's signing key - see security/JwtAuthorizationFilter. In a real
    // application this belongs in an externalized, secret-managed property.
    private static final String SECRET_KEY = "secretkey";
    private static final long EXPIRY_MILLIS = 1_200_000; // 20 minutes

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("Start");
        LOGGER.debug("authHeader:{}", authHeader);

        String user = getUser(authHeader);
        String token = generateJwt(user);

        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        LOGGER.info("End");
        return map;
    }

    private String getUser(String authHeader) {
        LOGGER.info("Start");
        String encodedCredentials = authHeader.replace("Basic ", "");
        String decoded = new String(Base64.getDecoder().decode(encodedCredentials));
        String user = decoded.substring(0, decoded.indexOf(':'));
        LOGGER.debug("user:{}", user);
        LOGGER.info("End");
        return user;
    }

    private String generateJwt(String user) {
        LOGGER.info("Start");
        JwtBuilder builder = Jwts.builder();
        builder.setSubject(user);
        builder.setIssuedAt(new Date());
        builder.setExpiration(new Date(System.currentTimeMillis() + EXPIRY_MILLIS));
        builder.signWith(SignatureAlgorithm.HS256, SECRET_KEY);

        String token = builder.compact();
        LOGGER.info("End");
        return token;
    }
}
