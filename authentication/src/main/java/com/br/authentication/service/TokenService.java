package com.br.authentication.service;

import java.util.Date;

import com.br.authentication.exception.UnauthorizedException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

    @Value("${authentication.jwt.expiration}")
    private String expiration;
    
    @Value("${authentication.jwt.secret}")
    private String secret;
    
    public String generateToken(String username) {

        Date today = new Date();
        Date expirationLimit = new Date(today.getTime() + Long.parseLong(this.expiration));

        return Jwts.builder()
                        .setIssuer("AuthenticationService")
                        .setSubject(username)
                        .setIssuedAt(today)
                        .setExpiration(expirationLimit)
                        .signWith(SignatureAlgorithm.HS256, this.secret)
                        .compact();
    }
    
    public boolean isValid(String token) {
      try {			
        Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
        return true;
      } catch (Exception e) {
        return false;
      }
    }
    
    public String getUsername(String token) {
      if (this.isValid(token)) {
        return Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody().getSubject();
      }
      throw new UnauthorizedException("Invalid token!");
    }
}