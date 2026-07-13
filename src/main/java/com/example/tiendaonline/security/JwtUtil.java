package com.example.tiendaonline.security;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Base64;

public class JwtUtil {
    public static void main(String[] args) {
        var key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String encoded = Base64.getEncoder().encodeToString(key.getEncoded());
        System.out.println(encoded);
    }

}
