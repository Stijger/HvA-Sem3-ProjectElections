package com.election.backendjava.models.user.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.xml.crypto.dsig.Transform;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;

@Service
public class JwtService {
    // this is anything but secure or a good secret key
    private final String jwtSecretKey = "xtGOaHjH77U7D4k+82gWZmVgE0Km8rngFyB6/HalHXI=";
    private final long jwtExperation = 3_600_000*4;

    public long getExperation() { return this.jwtExperation; }

    public Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(this.getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String generateToken(
            HashMap<String, Object> extraClaims,
            UserDetails userDetails
    ) {
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + this.jwtExperation))
                .signWith(this.getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final Claims claims = extractAllClaims(token);
        final String username = claims.getSubject();
        final Date expiration = claims.getExpiration();
        return (username.equals(userDetails.getUsername()) && !expiration.before(new Date()));
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(this.jwtSecretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
