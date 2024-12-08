package com.example.jwt_token_app.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {
		
	private SecretKey SECRET_KEY = Jwts.SIG.HS256.key().build();//Keys.hmacShaKeyFor(Decoders.BASE64.decode(key));
	
	
	private long EXPIRATION_TIME = 1000*60*2;
	
	public String generateToken(String username){
		
		return Jwts.builder()
				.subject(username)
				.issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(SECRET_KEY)
				.compact();
		
	}

    public Boolean validateToken(String token) {
        
        return Jwts.parser().verifyWith(SECRET_KEY).build().parseSignedClaims(token).getPayload().getSubject().equals("rohann");
    }

}
