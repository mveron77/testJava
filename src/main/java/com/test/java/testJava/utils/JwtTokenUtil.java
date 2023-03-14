package com.test.java.testJava.utils;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenUtil implements Serializable {
	
	private static final long serialVersionUID = -2550185165626007488L;

	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

	@Value("${jwt.secret}")
	private String secret;
	
	//retrieve username from jwt token
	public String getUsernameFromToken(String token) {
		return null;
	}

	//retrieve expiration date from jwt token
	public Date getExpirationDateFromToken(String token) {
		return null;
	}
}
