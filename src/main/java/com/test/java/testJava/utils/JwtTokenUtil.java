package com.test.java.testJava.utils;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {
	
	private static final long serialVersionUID = -2550185165626007488L;

	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

	@Value("${jwt.secret}")
	private String secret;
	
	public String getUsernameFromToken(String token) {
		return getAllClaims(token).getSubject();
	}

    public String generateToken(Map<String, Object> claims, String subject){
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
    }

    public boolean validateToken(String token,UserDetails userDetails){
        return userDetails.getUsername().equals(getUsernameFromToken(token))
                && !isTokenExpired(token);
    }

    public boolean isTokenExpired(String token){
        return getAllClaims(token).getExpiration().before(new Date());
    }

    private Claims getAllClaims(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }
    
    public String tokenCreate(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        return generateToken(claims, userDetails.getUsername());
    }
}
