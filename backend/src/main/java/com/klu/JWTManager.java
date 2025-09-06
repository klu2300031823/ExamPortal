package com.klu;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;


@Service
public class JWTManager {
	
	public final String SEC_KEY="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	public final SecretKey key = Keys.hmacShaKeyFor(SEC_KEY.getBytes());
	
	public String generateToken(String username) {
	    Map<String,String> data=new HashMap<String,String>();
	    data.put("username",username);
	    
	    return Jwts.builder()
	        .setClaims(data)
	        .setIssuedAt(new Date())
	        .setExpiration(new Date(new Date().getTime()+86556654))
	        .signWith(key)
	        .compact();
	  }

	public String validateToken(String token) {
		// TODO Auto-generated method stub
		Claims claims = Jwts.parserBuilder()
				.setSigningKey(key)
				.build()
				.parseClaimsJws(token)
				.getBody();
		Date expiry = claims.getExpiration();
		if(expiry==null || expiry.before(new Date()))
			return "401";
		
		return claims.get("username",String.class);
	}

}