package com.springboot.boilerplate.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {


    // Should be environment variable for production
    private String secret = "mysecretkey";

    public String generateToken(int id) throws IllegalArgumentException, JWTCreationException {

        return JWT.create()
                .withSubject("User Details")
                .withClaim("id", id)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + (360L * 24 * 60 * 60 * 1000)))
                .withIssuer("boilerplate")
                .sign(Algorithm.HMAC256(secret));
    }

    public String validateTokenAndRetrieveSubject(String token) throws JWTVerificationException {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
                .withSubject("User Details")
                .withIssuer("boilerplate")
                .build();
        DecodedJWT jwt = verifier.verify(token);
        return jwt.getClaim("id").asInt().toString();
    }

}