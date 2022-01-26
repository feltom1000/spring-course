package com.spring.course.web.secutiry;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {
    private static final String KEY = "password";

    public String generateToken(UserDetails userDetails){
        return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, KEY).compact();
        //Estoy construyendo un JWTS(Jsonwebtoken), le seteo el user, lo obtengo, le pongo la hora de creacion
        //le pongo la hora de vencimiento, le asigno un cifrado de algoritmo, y le asigno una key.
    }
}
